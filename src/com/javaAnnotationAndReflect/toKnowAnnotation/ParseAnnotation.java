package com.javaAnnotationAndReflect.toKnowAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 解析 Annotation
 */
public class ParseAnnotation {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.javaAnnotationAndReflect.toKnowAnnotation.Person");
            //获取类上所有效注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println("获取类上所有效注解："+a);
            }
            //获取类上指定的有效注解
            Annotation annotation = clazz.getAnnotation(SelfDefiningAnnotation.class);
            System.out.println("获取类上指定的有效注解：" + annotation);

            //获得方法上的注解(字段的操作类似)
            Method sing = clazz.getDeclaredMethod("sing", null);
            SelfDefiningAnnotation annotation1 = sing.getAnnotation(SelfDefiningAnnotation.class);
            System.out.println("获得方法上的注解：" + annotation1+"\n"+"获取方法注解上的值："+annotation1.desc()+" "+annotation1.author()+" "+annotation1.age());


        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
