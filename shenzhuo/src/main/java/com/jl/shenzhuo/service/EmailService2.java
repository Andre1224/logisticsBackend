package com.jl.shenzhuo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description:
 * @Date: 2021/12/6
 * @Time: 23:18
 **/
@Service
public class EmailService2 {

    @Resource
    private JavaMailSenderImpl mailSender;

    @Value("${spring.mail.username}")
    private String mailUsername;

    @Resource
    private TemplateEngine templateEngine;

    /**
     * 激活账号邮件发送
     * @param activationUrl  激活url链接
     * @param email  收件人邮件
     */
    public void sendMailForActivationAccount(String activationUrl, String email) throws MessagingException {
        //创建邮件对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
        //设置邮件主题
        message.setSubject("欢迎来到神州物流-个人账号激活");
        //设置邮件发送者
        message.setFrom(mailUsername);
        //设置邮件的接收者，可以多个
        message.setTo(email);
        //设置邮件的抄送人，可以多个
        //message.setCc();
        //设置隐秘抄送人，可以多个
        //message.setBcc();
        //设置邮件发送日期
        message.setSentDate(new Date());
        //创建上下文环境
        Context context = new Context();
        context.setVariable("activationUrl",activationUrl);
        String text = templateEngine.process("activation-account.html",context);
        //设置邮件正文
        message.setText(text,true);
        //邮件发送
        mailSender.send(mimeMessage);
    }


}
