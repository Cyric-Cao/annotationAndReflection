package com.javaAnnotationAndReflect.toKnowReflection;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 通过 javaCompiler 动态编译
 */
public class OperateToCompiler {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**
         * 获得系统动态编译器
         */
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        int run = systemJavaCompiler.run(null, null, null, "D:/myjava/HelloWorld.java");
        System.out.println(run == 0 ? "编译成功！" : "编译失败！");

        /**
         * 通过 Runtime.getRuntime() 运行启动新的进程运行
         */
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("java -cp D:/myjava  HelloWorld");
        InputStream inputStream = exec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String info = "";
        while ((info = reader.readLine()) != null) {
            System.out.println(info);
        }

        /**
         * 通过反射运行编译好的类
         */
        URL[] urls = new URL[]{new URL("file:/" + "D:/myjava/")};
        URLClassLoader loader = new URLClassLoader(urls);
        Class<?> helloWorld = loader.loadClass("HelloWorld");
        //调用加载类的 main 方法
        Method m = (Method) helloWorld.getMethod("main", String[].class);
        m.invoke(null, (Object) new String[]{});


    }
}
