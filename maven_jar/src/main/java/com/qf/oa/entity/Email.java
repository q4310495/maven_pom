package com.qf.oa.entity;

import org.springframework.web.multipart.MultipartFile;

public class Email {
    private String  formName;
    private  String toName;
    private  String title;
    private  String content;
    private MultipartFile file;

    @Override
    public String toString() {
        return "Email{" +
                "formName='" + formName + '\'' +
                ", toName='" + toName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", file=" + file +
                '}';
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
