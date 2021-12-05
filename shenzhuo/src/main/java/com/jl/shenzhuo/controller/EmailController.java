package com.jl.shenzhuo.controller;


import com.jl.shenzhuo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description:
 * 邮箱验证
 * @Date: 2021/11/27
 * @Time: 11:48
 **/

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @RequestMapping("/send1")
    public String sendSimpleEmail(){
        String to = "1625987873@qq.com";
        String subject = "验证码信息";
        String text = "验证码：24rgrd";
        emailService.sendSimpleEmail(to,subject,text);
        return "邮件发送成功！";
    }

    @RequestMapping("/send2")
    public String sendComplexEmail() {

        String to = "1625987873@qq.com";
        String subject = "[复杂邮件]测试";
        //定义邮件内容
        StringBuilder  text = new StringBuilder();
        text.append("<html><head></head>");
        text.append("<body><h1>从i额外内测</h1>");
        text.append("能否文化</body>");
        text.append("</html>");
        //指定静态资源文件和附件路径
        String filePath="C:\\Users\\jinle\\Desktop\\2.jpg";
        //发送复杂邮件
        emailService.sendComplexEmail(to,subject,text.toString(),filePath);
        return "复杂邮件发送成功";
    }
}
