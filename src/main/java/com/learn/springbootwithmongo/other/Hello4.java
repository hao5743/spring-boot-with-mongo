package com.learn.springbootwithmongo.other;

/**
 * 内部类声明为static = 静态内部类 = 嵌套类
 *
 */
public class Hello4 {
    static class Hello_4_1 {
        static void sayHi() {
            System.out.println("Hello_4_1 sayHi");
        }
    }
    public static void main(String[] args) {
        Hello4.Hello_4_1.sayHi();
    }
}
