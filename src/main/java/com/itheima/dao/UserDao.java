package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangfeng
 */

public interface UserDao {

    /**
     * 添加操作
     *
     * @param user
     * @return
     */
    public boolean save(User user);

    /**
     * 更新操作
     *
     * @param user
     * @return
     */

    public boolean update(User user);

    /**
     * 删除操作
     *
     * @param uuid
     * @return
     */

    public boolean delete(Integer uuid);

    /**
     * 查询单个
     *
     * @param uuid 根据id进行查询
     * @return
     */
    public User get(Integer uuid);

    /**
     * 查询所有的信息
     *
     * @return
     */
    public List<User> getAll();

    /**
     * 根据用户名和密码查询用户信息
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */

    public User getByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);


    List<User> getAll(int page, int size);
}
