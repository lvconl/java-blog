package com.blog.entity;

import java.util.Date;
/**
 * @author lvconl
 * 类说明：博客文章实体
 * */
public class Article {
    private String id;
    private String title;
    private String summary;
    private String content;
    private long createAt;
    private int commentCount;
    private int likeCount;
    private String typeId;
    private String timeString;

    public Article(){}

    public Article(String content, String typeId) {
        this.content = content;
        this.typeId = typeId;
    }

    public Article (String id,String title,String summary, String content, String typeId) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.typeId = typeId;
        Date date = new Date();
        this.createAt = date.getTime();
        this.commentCount = 0;
        this.likeCount = 0;
    }

    public Article(String id,String title, String summary, String content,long createAt, int commentCount, int likeCount, String typeId) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.typeId = typeId;
        this.createAt = createAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getSummary() { return summary; }

    public void setSummary(String summary) { this.summary = summary; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void  setTimeString(String timeString) { this.timeString = timeString; }

    public String getTimeString() { return timeString; }
}
