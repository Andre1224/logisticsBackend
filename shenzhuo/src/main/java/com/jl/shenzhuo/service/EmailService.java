package com.jl.shenzhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description:
 * 邮件
 * @Date: 2021/12/5
 * @Time: 17:27
 **/
@Service
public class EmailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Value("${spring.mail.username}")
    private String from;

    //纯文本邮件信息发送
    public void sendSimpleEmail(String to,String subject,String text){
        //定制纯文本的邮件信息sendSimpleEmail
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    //带附件邮件信息的发送
    public void sendComplexEmail(String to,String subject,String text, String filePath){
        //定制负责邮件信息MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        //使用MimeMessageHelper帮助类，并设置multipart多部件使用为true
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text,true);
            //设置邮件静态资源
            //FileSystemResource res=new FileSystemResource(new File(rscPath));
            //helper.addInline(rscId, res);
            //设置附件地址
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            //发送邮件
            mailSender.send(message);
            System.out.println("复杂邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("复杂邮件发送失败。。。。。。");
            e.printStackTrace();
        }
    }
}
