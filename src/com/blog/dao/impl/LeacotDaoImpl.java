package com.blog.dao.impl;

import com.blog.dao.ILeacotDao;
import com.blog.entity.Leacot;
import com.blog.util.DBUtil;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lvconl
 * 类说明：留言dao层方法实现
 * */
public class LeacotDaoImpl implements ILeacotDao {
    private static Logger logger = Logger.getLogger(LeacotDaoImpl.class);
    /**
     * 新增留言
     *
     * @param leacot (新增留言实例)
     * @return 操作状态，成功返回true、失败返回false
     */
    @Override
    public boolean addLeacot(Leacot leacot) {
        String sql = "INSERT INTO leacot(id, email, content, create_at) VALUES (?, ?, ?, ?)";
        return DBUtil.executeUpdate(sql, leacot.getId(), leacot.getEmail(), leacot.getContent(), leacot.getCreateAt());
    }

    /**
     * 删除留言
     *
     * @param id
     */
    @Override
    public boolean deleteLeacotById(String id) {
        String sql = "DELETE FROM leacot WHERE id=?";
        return DBUtil.executeUpdate(sql, id);
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
        List<Leacot> leacots = new ArrayList<>();
        String sql = "SELECT * FROM leacot LIMIT ?,?";
        ResultSet rs = DBUtil.executeQuery(sql, (currentPage - 1) * pageSize, pageSize);
        try {
            Leacot leacot = null;
            while (rs.next()) {
                leacot = new Leacot(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                leacots.add(leacot);
            }
        } catch (SQLException e) {
            logger.error("按页查询留言错误,SQL语句为<" + sql + "页码为<" + currentPage + ">...");
            e.printStackTrace();
        }
        return leacots;
    }

    /**
     * 获取留言总数
     *
     * @return 返回留言总数
     */
    @Override
    public int getTotalCount() {
        String sql = "SELECT COUNT(1) FROM leacot";
        ResultSet rs = DBUtil.executeQuery(sql);
        int count = 0;
        try {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("获取留言总数失败...");
            e.printStackTrace();
        }
        return count;
    }
}
