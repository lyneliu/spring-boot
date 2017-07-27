package com.lyne;

import com.lyne.entity.UserEntity;
import com.lyne.mapper.CustomUserMapper;
import com.lyne.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * MyBatis组件单元测试
 *
 * @author nn_liu
 * @Created 2017-07-03-13:50
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTests {

    @Autowired
    private UserMapper UserMapper;

    @Autowired
    private CustomUserMapper customUserMapper;

    @Test
    public void testInsert() throws Exception {
        UserMapper.insert(new UserEntity("aa", "a123456", "0"));
        UserMapper.insert(new UserEntity("bb", "b123456", "1"));
        UserMapper.insert(new UserEntity("cc", "b123456", "1"));

        Assert.assertEquals(3, UserMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<UserEntity> users = UserMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        UserEntity user = UserMapper.getOne(30l);
        System.out.println(user.toString());
        user.setNickName("neo");
        UserMapper.update(user);
        Assert.assertTrue(("neo".equals(UserMapper.getOne(30l).getNickName())));
    }

    @Test
    public void testDynamicMybatis(){

        UserEntity user = null;

        // 新增测试
        System.out.println("------------ 新增测试 ------------");
        user = new UserEntity();
        user.setId(3L);
        user.setUserName("conanli");
        user.setPassWord("123456");
        System.out.println("insert: " + customUserMapper.insert(user));

        // 更新测试
        System.out.println("------------ 更新测试 ------------");
        user = new UserEntity();
        user.setId(1L);
        user.setPassWord("111111");
        System.out.println("update: " + customUserMapper.updateByPrimaryKey(user));

        // 获取测试
        System.out.println("------------ 获取测试 ------------");
        System.out.println("user: " + customUserMapper.selectByPrimaryKey(1L));

        // 删除测试
        System.out.println("------------ 删除测试 ------------");
        System.out.println("delete: " + customUserMapper.deleteByPrimaryKey(1L));

    }

}
