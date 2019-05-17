package com.javaAnnotationAndReflect.annotationTest;

/**
 * 测试通过注解方式，输出 sql 语句
 */
public class TestUseAnnotationToSql {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setId(9);  //查询id为9的用户

        User u2 = new User();
        u2.setUserName("JTZeng"); 	//模糊查询用户名为JTZeng的用户
        u2.setAge(21);

        User u3 = new User();
        u3.setEmail("123@163.com,123@qq.com"); 	//查询邮箱有任意一个的用户

        String sql1 = ReturnQuery.query(u1); 	//查询id为9的用户
        String sql2 = ReturnQuery.query(u2);	//查询用户名为JTZeng和年龄为21的用户
        String sql3 = ReturnQuery.query(u3);	//查询邮箱中有任意一个的用户

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

    }
}
