package com.finance;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Mail {

	public static void sendMail(List<User> users) {
		final Properties configurationProperties =
			getMailConfigurationProperties();

		Session session = Session.getInstance(configurationProperties,
			new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(
						configurationProperties.getProperty("email.address"),
						configurationProperties.getProperty("password"));
				}
			});

		for (User user : users) {
			Message message = populateMessage(
				user, configurationProperties.getProperty("email.address"),
				session);

			try {
				Transport.send(message);

				System.out.println("Done sending email");
			}
			catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	private static Properties getMailConfigurationProperties() {
		Properties defaultConfigurationFile = new Properties();
		Properties customConfigurationFile = new Properties();
		Properties mergedProperties = new Properties();

		try {
			defaultConfigurationFile.load(
				Main.class.getClassLoader().getResourceAsStream(
					"config-default.properties"));
		}
		catch (Exception e) {
			throw new RuntimeException(
				"Could not load default properties file", e);
		}

		try {
			FileInputStream file;

			file = new FileInputStream(_CUSTOM_PROPERTIES_PATH);

			customConfigurationFile.load(file);
		}
		catch (Exception e) {
			System.out.println(
				"No custom properties file found. Using default properties.");
		}

		mergedProperties.putAll(defaultConfigurationFile);

		if (!customConfigurationFile.isEmpty()) {
			mergedProperties.putAll(customConfigurationFile);
		}

		return mergedProperties;
	}

	private static Message populateMessage(
		User user, String emailFrom, Session session) {

		try {
			List<Stock> stocks = Stock.getUsersStocks(user);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailFrom));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(user.getEmailAddress()));
			message.setSubject(
				"Average Investor Digest for " +
					_DATE_FORMAT.format(new Date()));

			Configuration cfg = new Configuration();
			cfg.setClassForTemplateLoading(Main.class, "templates");

			Template template = cfg.getTemplate("mail-template.ftl");

			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("recipient", user.getFullName());
			rootMap.put("stocks", stocks);

			Writer out = new StringWriter();

			template.process(rootMap, out);

			message.setText(out.toString());

			return message;
		}
		catch (Exception e) {
			throw new RuntimeException(
				"Could not properly populate the message", e);
		}
	}

	private static String _CUSTOM_PROPERTIES_PATH = "./config.properties";

	private static final DateFormat _DATE_FORMAT =
		new SimpleDateFormat("MM/dd/yyyy");
}
