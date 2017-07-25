package visao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.SendMail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@ManagedBean(name="sendMailBean")
@SessionScoped
public class SendMailBean {
	private String assunto;
	private String mensagem;
	private String envia = "trintaumlol@gmail.com";
	private String recebe = "rip.figueira@gmail.com";
	
	public SendMailBean() {

	}

	public void enviaEmail(){
		new SendMail().sendMail(envia, recebe, assunto, mensagem);
	}
	
}
