package com.qf.oa.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeDomain {
        private Integer id;

        private String email;


        private String password;


        private String name;


        private String phone;


        private Integer sex;


        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private String birthday;


        private String einfo;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private String entrytime;

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", sex=" + sex +
                    ", birthday=" + birthday +
                    ", einfo='" + einfo + '\'' +
                    ", entrytime=" + entrytime +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
            String format = formatter.format(birthday);
            this.birthday = format;
        }

        public String getEinfo() {
            return einfo;
        }

        public void setEinfo(String einfo) {
            this.einfo = einfo;
        }

        public String getEntrytime() {
            return entrytime;
        }

        public void setEntrytime(Date entrytime) {
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
            String format = formatter.format(entrytime);
            this.entrytime = format;
        }


}
