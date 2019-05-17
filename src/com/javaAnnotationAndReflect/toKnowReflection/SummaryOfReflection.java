package com.javaAnnotationAndReflect.toKnowReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射概述
 */
public class SummaryOfReflection {

    /**
     *  反射机制
     *      -值得是可以于运行时加载，探知，使用编译期间完成未知的类。
     *      -程序在运行状态中，可以动态加载一个只有名称的类，对于任意一个已加载的类，都能够知道这个类的所有属性和方法
     *       对于任意一个对象，都能够调用它的任意一个方法和属性
     *      -加载完类之后，在堆内存中，就会产生一个 Class 类型的对象(一个类只有一个 Class 对象)，这个对象就包含了完整的类的结构信息。
     *       我们可以通过这个对象看到类的结构。这个对象就像一面镜子，透过这个镜子看到类的结构，所以我们形象的称之为：反射。
     */

    public static void main(String[] args) {

        try {
            //1.通过 Class.forName() 方法来获取 Class 对象
            Class userClazz = Class.forName("com.javaAnnotationAndReflect.toKnowReflection.User");

            //2.通过 .class 来获得 Class 对象
            Class strClazz = String.class;
            System.out.println(strClazz);

            //3.通过 .getClass() 方法获取 Class 对象
            String a = "a";
            Class aClass = a.getClass();
            System.out.println(aClass == strClazz);

            //获取类的名称
            System.out.println("返回是类的全路径加类名:"+userClazz.getName()); //返回是类的全路径加类名
            System.out.println("返回的只是类名:"+userClazz.getSimpleName()); //返回的只是类名

            //获取属性信息
//            Field[] fields = userClazz.getFields();  //只能获取public修饰的feild
            Field[] declaredFields = userClazz.getDeclaredFields(); //获取所有的feild
            Field userName = userClazz.getDeclaredField("userName");//获取指定的属性名称
            System.out.println("获取指定的属性名称:"+userName);
            for (Field field : declaredFields) {
                System.out.println("获取属性所有信息：" + field);
                System.out.println("只获取属性名称：" + field.getName());
            }

            //获取方法信息

            //获取所有的方法
            Method[] declaredMethods = userClazz.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.println("获取方法所有的信息：" + method);
            }
            //根据方法名称获取指定的方法
            Method getUserName = userClazz.getDeclaredMethod("getUserName");
            //如果方法有参，则必须传递参数类型对应的 class 对象
            Method getUserName1 = userClazz.getDeclaredMethod("setUserName", String.class);


            //获得构造器信息

            //获得所有的构造器
            Constructor[] declaredConstructors = userClazz.getDeclaredConstructors();
            for (Constructor c : declaredConstructors) {
                System.out.println("构造器信息："+c);
            }
            //获取指定的构造器
            Constructor declaredConstructor = userClazz.getDeclaredConstructor(String.class, String.class, int.class);
            System.out.println("指定构造器："+declaredConstructor);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
