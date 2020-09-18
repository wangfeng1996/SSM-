package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.common.JsonData;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangfeng
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //添加
    @PostMapping
    public JsonData save(User user) {
        boolean save = userService.save(user);
        System.out.println(save);
        if (save) {
            return JsonData.success();
        } else {
            return JsonData.fail("添加失败");
        }
    }

    //删除
    @DeleteMapping("/{uuid}")
    public JsonData delete(@PathVariable Integer uuid) {
        boolean delete = userService.delete(uuid);
        if (delete) {
            return JsonData.success();
        } else {
            return JsonData.fail("删除失败");
        }
    }

    //修改
    @PutMapping
    public JsonData update(User user) {
        boolean update = userService.update(user);
        if (update) {
            return JsonData.success();
        } else {
            return JsonData.fail("更新失败");
        }

    }

    //    根据id查询
    @GetMapping("/{uuid}")
    public JsonData getById(@PathVariable Integer uuid) {
        User user = userService.get(uuid);
        return JsonData.success(user);
    }

    //分页查询
    @GetMapping("/{page}/{size}")
    public JsonData getAll(@PathVariable Integer page, @PathVariable Integer size) {
        PageInfo<User> all = userService.getAll(page, size);
        return JsonData.success(all);
    }

    //登陆查询
    @PostMapping("/login")
    public JsonData login(String userName, String password) {
        User login = userService.login(userName, password);
        return JsonData.success(login);
    }
}