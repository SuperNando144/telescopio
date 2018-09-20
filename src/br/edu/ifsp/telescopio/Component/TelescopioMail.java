package br.edu.ifsp.telescopio.Component;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TelescopioMail {
	private String to;
	private String from = "turtleticketsnoreply@gmail.com";

	private Properties properties;
	private Session session;

	public TelescopioMail(String to) {
		this.to = to;

		this.properties = new Properties();

		this.properties.put("mail.transport.protocol", "smtp");

		this.properties.put("mail.smtp.starttls.enable", "true");
		this.properties.put("mail.host", "smtp.gmail.com");
		this.properties.put("mail.smtp.port", "587");

		this.properties.put("mail.smtp.auth", "true");

		this.session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("telescopionoreply@gmail.com", "Te3lesc@pio.");
			}
		});
	}

	public boolean enviaEmailConfirmando(Integer cod) {
		try {

			String assunto = "[Observatorium] Confirme seu email!";
			MimeMessage message = new MimeMessage(this.session);
			message.setFrom(new InternetAddress(this.from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
			message.setSubject(assunto);
			message.setContent(
					"<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"></head><body><header>"
							+ "<center><img src=\"https://i.imgur.com/rJrFzqe.png\" alt=\"Observatorium\"></center>"
							+ "</header><center><h2>"
							+ "Obrigado por se cadastrar no sistema Observatorium!<br/>Para que você acesse a sua conta é necessário confirmar o seu email, entrando no link abaixo:<br/>"
							+ "<a href=\"http://observatorium-env.icuyrk26x8.us-east-2.elasticbeanstalk.com/confirmar\">Confirme seu email!</a><br/>"
							+ "Para a verificação será necessário utilizar o seguinte código:<br/>" + cod
							+ "</h2><h4><i>Que as estrelas do céu iluminem sua noite!</i></h4>"
							+ "<h5>Equipe Observatorium</h5>" + "</center></body></html>",
					"text/html");

			Transport.send(message);

			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();

			return false;
		}
	}

	public boolean lembreteData(String data) {
		try {

			String assunto = "[Observatorium] Agendamento criado!";
			MimeMessage message = new MimeMessage(this.session);
			message.setFrom(new InternetAddress(this.from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
			message.setSubject(assunto);
			message.setContent(
					"<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"></head><body><header>"
							+ "<center><img src=\"https://i.imgur.com/rJrFzqe.png\" alt=\"Observatorium\"></center>"
							+ "</header><center><h2>"
							+ "Obrigado por acessar o sistema Observatorium!<br/>Foi criado um novo agendamento para essa conta no dia:<br/>"
							+ data
							+ "<br/>Lembre-se de anotar essa data em sua agenda! Você terá acesso durante o telescópio esse dia inteiro.</h2>" 
							+ "<h4><i>Que as estrelas do céu iluminem sua noite!</i></h4>"
							+ "<h5>Equipe Observatorium</h5>" + "</center></body></html>",
					"text/html");

			Transport.send(message);

			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();

			return false;
		}
	}
}
