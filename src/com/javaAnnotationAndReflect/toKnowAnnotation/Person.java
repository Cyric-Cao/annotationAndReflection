package com.javaAnnotationAndReflect.toKnowAnnotation;

@SelfDefiningAnnotation(desc = "定义 Human 类", author = "Human", age = 15)
public class Person {

    @SelfDefiningAnnotation(desc = "唱歌方法", author = "林宥嘉", age = 17)
    public void sing(){}


}
