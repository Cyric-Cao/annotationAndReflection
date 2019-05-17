package com.javaAnnotationAndReflect.toKnowAnnotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SelfDefiningAnnotation {

    String desc(); //成员以无参无异常方式生命

    String author();

    int age() default 18; //可以用 default 为成员指定一个默认值

    /**
     *  使用 @interface 自定义注解时，自动继承了 java.lang.annotation.Annotation 接口
     *
     *  要点：
     *      -@interface 用来声明一个注解
     *          -格式：public @interface 注解名 {定义体}
     *      -其中的每一个方法实际上是声明了一个配置参数
     *          -方法的名称就是参数的名称
     *          -返回值类型及时参数的类型 (返回值类型只能是基本类型，Class,String,enum)。
     *          -可以通过 default 来声明参数的默认值。
     *          -如果只有一个参数成员，一般参数名为 value。
     *      -注解类可以没有成员，没有成员的注解称为标识注解。
     *
     *  元注解：
     *      -@Target : 用来标识作用域
     *          1.5
     *           -@Target(ElementType.TYPE)  注解可以定义在接口、类、枚举、注解上。
     *           -@Target(ElementType.FIELD) 注解可以定义在字段、枚举的常量。
     *           -@Target(ElementType.METHOD) 注解可以定义在方法上。
     *           -@Target(ElementType.PARAMETER) 注解可以定义在方法参数上。
     *           -@Target(ElementType.CONSTRUCTOR) 注解可以定义在构造方法上。
     *           -@Target(ElementType.LOCAL_VARIABLE) 注解可以定义在局部变量上。
     *           -@Target(ElementType.ANNOTATION_TYPE) 注解可以定义在注解上。
     *           -@Target(ElementType.PACKAGE)  注解可以声明在包上。
     *          1.8之后新增了两个注解：
     *           -@Target(ElementType.TYPE.PARAMETER)  用于类型参数声明语句
     *           -@Target(ElementType.TYPE_USE)  表示注解可以在任何用到类型的地方使用
     *      -@Retention : 用来标识生命周期
     *           -@Retention(RetentionPolicy.SOURCE)   注解仅存在于源码中，在class类文件中不存在。
     *           -@Retention(RetentionPolicy.CLASS)  默认的保留策略，注解在字节码文件中存在，但是运行时无法通过反射获得。
     *           -@Retention(RetentionPolicy.RUNTIME) 注解在class文件中存在，在运行时可以通过反射获得。
     *      -@Inherited ：允许子类继承，只会继承父类中类上的注解。
     *      -@Documented : 生成javadoc时会包含注解。
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */


}
