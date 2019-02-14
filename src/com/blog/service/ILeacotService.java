package com.blog.service;

import com.blog.entity.Leacot;

import java.util.List;

/**
 * @author lvconl
 * 类说明：定义留言service层方法
 * */
public interface ILeacotService {
    /**
     * 新增留言
     * @param email (留言者邮箱)
     * @param content (留言内容)
     * @return 操作状态，成功返回true，否则返回false
     * */
    boolean addLeacot(String email, String content);
    /**
     * 根据id删除留言
     * @param id (留言id)
     * @return 操作状态，成功返回true，否则返回false
     * */
    boolean deleteLeacotById(String id);
    /**
     * 根据分页信息查询留言
     * @param currentPage (当前页)
     * @param pageSize (页面大小)
     * @return 查询到的页面集合
     * */
    List<Leacot> queryLeacotByPage(int currentPage, int pageSize);
    /**
     * 获取留言总数
     * @return 返回留言总数
     * */
    int getTotalCount();
    /**
     * 替换邮箱中间位置信息
     * @param leacots (欲替换的留言集合)
     * */
    void replaceEmail(List<Leacot> leacots);
}
