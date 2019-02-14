package com.blog.entity;

/**
 * @author lvconl
 * 类说明：博客文章类型实体
 * */
public class BlogType {
    private String id;
    private String typeName;

    public BlogType () {};

    public BlogType (String typeName) {
        this.typeName = typeName;
    }

    public BlogType (String id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
