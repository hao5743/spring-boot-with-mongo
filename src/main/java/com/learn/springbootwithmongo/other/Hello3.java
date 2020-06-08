package com.learn.springbootwithmongo.other;

/**
 * 如何在接口里共享一段代码, 答案:使用接口的内部类
 * 接口的内部类默认都是static 和 public的
 */
interface Animal{
    public void howdy();
    class TestInner {
        static public void test1() {
            System.out.println("test1 in interface");
        }
    }
}

class Cat2 implements Animal {
    public void howdy() {
        System.out.println("howdy");
        Animal.TestInner.test1();
    }
}

class Cat3 implements Animal {
    public void howdy() {
        System.out.println("howdy");
        Animal.TestInner.test1();
    }
}

public class Hello3 {
    public static void main(String[] args) {
        new Cat2().howdy();
        new Cat3().howdy();
    }
}
