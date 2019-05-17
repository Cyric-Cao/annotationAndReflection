package com.javaAnnotationAndReflect.toKnowAnnotation;

/**
 * 注解概述
 */
public class SummaryOfAnnotation {
    /**
     *  Annotation 是从 Java 1.5 开始引入的新技术
     *  Annotation 的作用：
     *      -不是程序本身，可以对程序作出解释。（这点，跟注释没有区别）
     *      -可以被其他程序(比如：编译器等)读取。(注解信息处理流程，是注解和注释的重大区别。如果没有注解信息处理流程，则注解毫无意义)
     *  Annotation 的格式：
     *      -注解是以 “@注释名” 在代码中存在的，还可以添加一些参数值，例如：@SuppressWarnings(value=""unchecked)。
     *  Annotation 在哪里使用？
     *      -可以附加在 package,class,method,field等上面，相当于给它们添加了额外的辅助信息，我们可以通过反射机制编程实现对这些元数据的访问
     *
     *  内置注解：
     *      @Override /əʊvə'raɪd/
     *          -定义在 java.lang.Override 中，此注释只适用于修饰方法，表示一个方法声明打算重写超类中的另一个方法声明。
     *      @Deprecated /ˈdeprəkeɪtɪd/
     *          -定义在 java.lang.Deprecated 中，此注释可用于修饰方法，属性，类，表示不鼓励程序员使用这样的元素，通常是因为它很危险或存在更好的选择。
     *      @SuppressWarnings /sə'pres/ /'wɔːnɪŋs/
     *          -定义在 java.lang.SuppressWarning 中，用来抑制编译时的警告信息。
     *          -与前两个注释有所不同，你需要添加一个参数才能正确使用，这些参数值都是已经定义好的，我们选择性的使用就好了，参数如下：
     *              deprecation : 使用了过时的类或方法的警告
     *              unchecked : 执行了未检查的转换时的警告，如果使用集合时未指定泛型
     *              fallthrough : 当在 switch 语句使用时发生 case 穿透。
     *              path : 在类路径、源文件路径等中有不存在路径的警告。
     *              serial : 当在可序列化的类上缺少 serialVersionUID 定义是的警告。
     *              finally ：任何 finally 子句不能完成时的警告。
     *              all : 关于以上所有情况的警告。
     *          -@SuppressWarnings("unchecked")
     *          -@SuppressWarnings(value={"unchecked","deprecation"})
     *
     *
     *
     */

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
