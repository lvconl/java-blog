package com.blog.service.impl;

import com.blog.dao.ILeacotDao;
import com.blog.dao.impl.LeacotDaoImpl;
import com.blog.entity.Leacot;
import com.blog.service.ILeacotService;

import java.util.List;
import java.util.Random;

/**
 * @author lvconl
 * 实现leacot业务层方法
 * */
public class LeacotServiceImpl implements ILeacotService {
    private ILeacotDao leacotDao = new LeacotDaoImpl();
    /**
     * 当前时间戳+三位随机数生成id
     *
     * @return 随机产生的id
     */
    private String getId() {
        long simple = System.currentTimeMillis();
        int random = new Random().nextInt(999) + 100;
        return Long.toString(simple) + random;
    }
    /**
     * 新增留言
     * @param email (留言者邮箱)
     * @param content (留言内容)
     * @return 操作状态，成功返回true，否则返回false
     * */
    @Override
    public boolean addLeacot(String email, String content) {
        String id = getId();
        Leacot leacot = new Leacot(id,email,content);
        return leacotDao.addLeacot(leacot);
    }

    /**
     * 根据id删除留言
     *
     * @param id (留言id)
     * @return 操作状态，成功返回true，否则返回false
     */
    @Override
    public boolean deleteLeacotById(String id) {
        return leacotDao.deleteLeacotById(id);
    }

    /**
     * 根据分页信息查询留言
     *
     * @param currentPage (当前页)
     * @param pageSize    (页面大小)
     * @return 查询到的页面集合
     */
    @Override
    public List<Leacot> queryLeacotByPage(int currentPage, int pageSize) {
        return leacotDao.queryLeacotByPage(currentPage, pageSize);
    }

    /**
     * 获取留言总数
     *
     * @return 返回留言总数
     */
    @Override
    public int getTotalCount() {
        return leacotDao.getTotalCount();
    }

    /**
     * 替换邮箱中间位置信息
     *
     * @param leacots (欲替换的留言集合)
     */
    @Override
    public void replaceEmail(List<Leacot> leacots) {
        String replaceStr = "****";
        for (Leacot leacot:leacots) {
            StringBuilder emailSB = new StringBuilder(leacot.getEmail());
            leacot.setEmail(emailSB.replace(3,7, replaceStr).toString());
        }
    }
}
