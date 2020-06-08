package com.learn.springbootwithmongo.other;

/**
 * created by shaochong.com on 1:57 下午 2020/6/4
 */
public class HelloWorld {
    public static void main(String[] args) {
        Test.test();
        Test t1 = new Test();
        t1.doTest();
    }
}
class Test {

    // 类加载的时候初始化静态成员和执行静态代码块,第一次使用该类时(new\访问静态成员\方法)
    static Cat cat = new Cat();
    static {
        System.out.println("我是静态代码块");
    }

    static void test() {
        System.out.println("static test");
    }
    void doTest() {
        System.out.println("do test");
    }
    Test() {
        System.out.println("构造函数执行");
    }
    Test(String a) {
        this();
    }

}
class Cat {
    Cat() {
        System.out.println("Cat构造函数");
    }
    public void sayHi() {
        System.out.println("hi cat");
    }
}