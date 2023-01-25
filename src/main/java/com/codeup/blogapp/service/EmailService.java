//package com.codeup.blogapp.service;
//import com.codeup.blogapp.models.Post;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service("EmailService")
//public class EmailService {
//
//    @Autowired
//    public JavaMailSender javaMailSender;
//
//    @Value("${spring.mail.from}")
//    private String from;
//
//    public void preparedAndSend(Post post, String subject, String body){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(post.getUser().getEmail());
//        message.setSubject(subject);
//        message.setText(body);
//
//        try{
//            this.javaMailSender.send(message);
//        } catch(MailException ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//}
