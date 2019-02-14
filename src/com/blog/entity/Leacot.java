package com.blog.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lvconl
 * 留言实体类
 * */
public class Leacot {
    private String id;
    private String email;
    private String content;
    private String createAt;

    public Leacot() {}

    public Leacot(String id, String email, String content) {
        this.id = id;
        this.email = email;
        this.content = content;
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        this.createAt = df.format(new Date());
    }

    public Leacot(String id, String email, String content, String createAt) {
        this.id = id;
        this.email = email;
        this.content = content;
        this.createAt = createAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
