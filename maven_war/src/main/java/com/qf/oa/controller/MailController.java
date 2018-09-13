package com.qf.oa.controller;

import com.qf.oa.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/tomail")
    public String toMailEdit(){
        return "mailedit";
    }

    @RequestMapping("/sendmail")
    public String sendmail(final Email email) throws Exception {
        System.out.println(email);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("liangsha9472@sina.com");
        mimeMessageHelper.setTo(email.getToName());
        mimeMessageHelper.setSubject(email.getTitle());
        mimeMessageHelper.setText(email.getContent(),true);
        mimeMessageHelper.addAttachment(email.getFile().getOriginalFilename(), new InputStreamSource() {
            @Override
            public InputStream getInputStream() throws IOException {
                return email.getFile().getInputStream();
            }
        });
        mimeMessage = mimeMessageHelper.getMimeMessage();
         javaMailSender.send(mimeMessage);
        return "redirect:/mail/tomail";
    }
}
