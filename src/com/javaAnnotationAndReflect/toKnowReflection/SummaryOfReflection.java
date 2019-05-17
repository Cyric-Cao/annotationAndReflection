package com.javaAnnotationAndReflect.toKnowReflection;

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
            Class humanClazz = Class.forName("com.javaAnnotationAndReflect.toKnowReflection.User");

            //2.通过 .class 来获得 Class 对象
            Class strClazz = String.class;
            System.out.println(strClazz);

            //3.通过 .getClass() 方法获取 Class 对象
            String a = "a";
            Class aClass = a.getClass();
            System.out.println(aClass == strClazz);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
