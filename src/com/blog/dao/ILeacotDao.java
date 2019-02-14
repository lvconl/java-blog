package com.blog.dao;

import com.blog.entity.Leacot;

import java.util.List;

/**
 * @author lvconl
 * 类说明：Leacot相关dao层方法抽象定义
 * */
public interface ILeacotDao {
    /**
     * 新增留言
     * @param leacot (新增留言实例)
     * @return 操作状态，成功返回true、失败返回false
     * */
    boolean addLeacot(Leacot leacot);
    /**
     * 删除留言
     * @param id(要删除的留言id)
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
}
