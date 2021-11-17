package com.jl.shenzhuo.utils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description:
 * 验证码图片
 * @Date: 2021/11/17
 * @Time: 22:42
 **/

public class ImageUtil {
    private String str;//验证码
    private ByteArrayInputStream image;//验证码图片

    private int width = 350; //图片宽度
    private int height = 46; //图片高度

    private ImageUtil(){
        init();
    }
    public static ImageUtil getInstance(){
        return new ImageUtil();
    }
    private void init(){

        this.str = " ";
        final BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        final Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandomColor(200,250));
        g.fillRect(0,0,width,height);

        g.setFont(new Font("Times New Roman",Font.PLAIN,20));
        for (int i = 0; i < 6; i++) {
            final String rand = String.valueOf(random.nextInt(10));
            this.str += rand;
            g.setColor(getRandomColor(20,110));
            g.drawString(rand,(width/6)*i,46);
        }
        g.dispose();
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            final ImageOutputStream imageOut = ImageIO.createImageOutputStream(outputStream);
            ImageIO.write(image,"JPEG",imageOut);
            imageOut.close();
            inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        }catch (Exception e){
            System.out.println("验证码图片生成失败: "+e);
        }
        this.image = inputStream;
    }

    private Color getRandomColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255){fc = 255;}
        if (bc > 255){bc = 255;}
        int r = fc + random.nextInt(bc-fc);
        int g = fc + random.nextInt(bc-fc);
        int b = fc + random.nextInt(bc-fc);
        return new Color(r,g,b);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public ByteArrayInputStream getImage() {
        return image;
    }

    public void setImage(ByteArrayInputStream image) {
        this.image = image;
    }
}
