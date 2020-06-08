package com.learn.springbootwithmongo.other;

/**
 * 内部类继承自某个类或实现某个接口,内部类的代码可以操作创建他的外围类的对象
 * 所以可以认为,内部类提供了某个进入其外围类的窗口
 */

interface Contents {
}

class Hello_1 {
    public Contents getContent() {
        return new Contents() {
            // 定义一个匿名内部类 (创建一个继承自Contents的匿名类的对象) ,
            // 通过new表达式返回的引用被自动向上转型为Contents的引用
            private int i = 1;
            public int getI() {
                return i;
            }
        };
    }
}

// Hello1等价于下面这个
class Hello_2 {
    class MyContents implements Contents {
        private int i = 1;
        public int getI() {
            return i;
        }
    }
    public Contents getContent() {
        return new MyContents();
    }

}

public class Hello2 {

    public static void main(String[] args) {
        System.out.println("2");
    }
}
