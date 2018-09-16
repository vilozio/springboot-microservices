package org.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.webapp.entity.Mail;
import org.webapp.entity.dto.UserDto;
import org.webapp.repository.MailRepository;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender emailSender;
    private MailRepository mailRepository;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender, MailRepository mailRepository) {
        this.emailSender = emailSender;
        this.mailRepository = mailRepository;
    }

    @Override
    public void sendSimpleMessage(UserDto input) {
        try {

            Mail newMail = new Mail();
            newMail.setTo(input.getUsername());
            newMail.setSubject("TestSubject");
            newMail.setText("TestText");

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(newMail.getTo());
            message.setSubject(newMail.getSubject());
            message.setText(newMail.getText());

            mailRepository.save(newMail);
//            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }

    }
}
