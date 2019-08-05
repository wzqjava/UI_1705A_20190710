package com.wzq;

/**
 * <p>作者：wzq<p>
 * <p>创建时间：2019-07-10<p>
 * <p>文件描述：<p>
 */
public class Person {

    String name;
    String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
