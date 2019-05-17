package com.javaAnnotationAndReflect.toKnowReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射 API 动态的操作，构造器，方法，属性
  */
public class OperateReflection {

    public static void main(String[] args) {
        try {
            //通过反射 API 调用构造方法，构造对象
            Class<User> clazz = (Class<User>) Class.forName("com.javaAnnotationAndReflect.toKnowReflection.User");
            User u =  clazz.newInstance();  //其实就是调用的是对象的无参构造器
            System.out.println(u);

            Constructor<User> u1 = clazz.getDeclaredConstructor(String.class, String.class, int.class);
            User user = u1.newInstance("张三", "北京", 110);
            System.out.println(user.getUserName());

            /**
             * 通过反射 API 调用普通方法
             */
            User user2 = clazz.newInstance();
            Method setUserName = clazz.getDeclaredMethod("setUserName", String.class);
            setUserName.invoke(user2, "张四");
            System.out.println(user2.getUserName());

            /**通过反射 API 操作属性*/
            User user3 = clazz.newInstance();
            Field userName = clazz.getDeclaredField("userName");
            userName.setAccessible(true);  //不要做安全检查
            userName.set(user3, "张五"); //通过反射写属性值
            System.out.println(user3.getUserName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
