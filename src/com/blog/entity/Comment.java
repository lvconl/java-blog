package com.blog.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lvconl
 * 类说明：文章评论实体类
 * */
public class Comment {
    private String id;
    private String content;
    private String articleId;
    private String createAt;

    public Comment() {}

    public Comment(String id, String content, String articleId) {
        this.id = id;
        this.content = content;
        this.articleId = articleId;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        this.createAt = dateFormat.format(new Date());
    }

    public Comment(String id, String content, String articleId, String createAt) {
        this.id = id;
        this.content = content;
        this.articleId = articleId;
        this.createAt = createAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
