package com.jl.shenzhuo.controller;

import com.jl.shenzhuo.utils.ImageUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description:
 * @Date: 2021/11/17
 * @Time: 22:49
 **/
@RestController
@RequestMapping("/common")
public class LoginController {

    //产生验证码
    @RequestMapping("/verifyCode")
    public void generateImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final ImageUtil imageUtil = ImageUtil.getInstance();
        //验证码图片
        final ByteArrayInputStream image = imageUtil.getImage();
        //验证码文字
        final String verifyCode = imageUtil.getStr();
        request.getSession().setAttribute("verifyCode",verifyCode);

        response.setContentType("image/jpeg");
        byte[] bytes = new byte[1024];
        try (final ServletOutputStream out = response.getOutputStream()){
            while (image.read(bytes) != -1){
                out.write(bytes);
            }
        }

    }
}
