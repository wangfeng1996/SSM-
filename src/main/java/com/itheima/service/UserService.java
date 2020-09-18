package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wangfeng
 */
@Transactional(readOnly = true)
public interface UserService {
    /**
     * 添加操作
     *
     * @param user
     * @return
     */
    @Transactional(readOnly = false)
    public boolean save(User user);

    /**
     * 更新操作
     *
     * @param user
     * @return
     */

    @Transactional(readOnly = false)
    public boolean update(User user);

    /**
     * 删除操作
     *
     * @param uuid
     * @return
     */
    @Transactional(readOnly = false)
    public boolean delete(Integer uuid);

    /**
     * 查询单个用户信息
     *
     * @param uuid 根据id进行查询
     * @return
     */

    public User get(Integer uuid);

    /**
     * 查询所有的用户信息，这边利用分页进行查询
     *
     * @param page 当前页
     * @param size 一个共多少条数据
     * @return
     */

    public PageInfo<User> getAll(int page, int size);

    /**
     * 根据用户名和密码查询单个用户信息;
     *
     * @param userName 用户名
     * @param password 密码信息
     * @return
     */
    public User login(String userName, String password);

    /**
     * 查询所有的信息
     * @return
     */
    public List<User> getAll();
}
