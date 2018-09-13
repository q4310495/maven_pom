package com.qf.oa.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.UUID;

@Controller
@RequestMapping("/img")
public class UploadController {
    @Value("c:/work/img")
    private  String uploadPath;

    @RequestMapping("/upload")
    @ResponseBody
    public String imgUpload(MultipartFile file){
        InputStream fis=null;
        OutputStream fos=null;
        System.out.println("file:"+file);
        System.out.println("dsafasdf....................");
        try {
               fis=file.getInputStream();
            String path=uploadPath+"/"+ UUID.randomUUID().toString();
            fos=new FileOutputStream(path);
            System.out.println(path);
            IOUtils.copy(fis,fos);
            return "{\"fileuploader\":\"" + path + "\"}";
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return null;
    }

    @RequestMapping("/getImg")
    public void getImg(String path, HttpServletResponse response) {
       InputStream fis=null;
       OutputStream fos=null;
       try {
           fis=new FileInputStream(path);
           fos=response.getOutputStream();
           IOUtils.copy(fis,fos);

       }catch (Exception e){
           e.printStackTrace();
       }finally {
           if(fis!=null){
               try {
                   fis.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if(fos!=null){
               try {
                   fos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }


    }
}
