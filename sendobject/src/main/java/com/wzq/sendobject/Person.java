package com.wzq.sendobject;

import java.io.Serializable;

/**
 * <p>作者：wzq<p>
 * <p>创建时间：2019-07-12<p>
 * <p>文件描述：<p>
 *     如果想传递对象数据, 那么对象必须实现序列化
 *     如果想传递对象数据, 那么对象必须实现序列化
 *     如果想传递对象数据, 那么对象必须实现序列化
 */
public class Person implements Serializable {
    String name;
    String sex;
    String hobby;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
