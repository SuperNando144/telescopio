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
			String texto = "Obrigado por se cadastrar no sistema Observatorium!\nPara que voc� acesse a sua conta � necess�rio confirmar o seu email, entrando no link abaixo:\r\n"
					+ "http://localhost:8080/confirmar/" + 
					"\n� necess�rio utilizar o c�digo seguinte para a valida��o " + cod +
					"\nQue as estrelas do c�u iluminem sua noite!";
			MimeMessage message = new MimeMessage(this.session);

			message.setFrom(new InternetAddress(this.from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
			message.setSubject(assunto);
			message.setText(texto);

			Transport.send(message);

			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();

			return false;
		}
	}

	public boolean enviaEmailPagamentoRealizado() {
		try {

			String assunto = "Evento no qual vc realizou pagamento foi cancelado";
			String texto = "Evento Cancelado!!! \n Por favor acesse o link abaixo para ver mais detalhes: \n localhost:8080/ingresso/login";
			MimeMessage message = new MimeMessage(this.session);

			message.setFrom(new InternetAddress(this.from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
			message.setSubject(assunto);
			message.setText(texto);

			Transport.send(message);

			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();

			return false;
		}
	}
}
