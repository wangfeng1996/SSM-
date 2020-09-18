import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class myTest {
    @Autowired
    private UserService userService;

    //    查询所有的信息
    @Test
    public void testGetAll() {
        System.out.println(userService.getAll());
    }

    //    根据分页进行查询
    @Test
    public void testFindAll() {
        PageInfo<User> all = userService.getAll(1, 2);
        System.out.println(all);
        System.out.println(all.getList().get(0));
        System.out.println(all.getList().get(1));

    }

    //    添加信息
    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("jock1");
        user.setPassword("root1");
        user.setRealName("zhansan");
        user.setGender(1);
        user.setBirthday(new Date(100000000L));

        boolean save = userService.save(user);
        if (save) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    //    删除信息
    @Test
    public void testDelete() {
        boolean delete = userService.delete(5);
        if (delete) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    //    修改信息
    @Test
    public void testUpdate() {

        User user = new User();
        user.setUuid(3);
        user.setUserName("jock3");
        user.setPassword("root4");
        user.setRealName("zhansan");
        user.setGender(1);
        user.setBirthday(new Date(100000000L));
        boolean update = userService.update(user);
        if (update) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void testLogin() {
        User login = userService.login("jock3", "root4");
        System.out.println(login);
    }

}


