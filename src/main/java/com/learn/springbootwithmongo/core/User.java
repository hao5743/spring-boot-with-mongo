package com.learn.springbootwithmongo.core;

/**
 * created by shaochong.com on 11:58 上午 2020/6/4
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    private String name;
    private String remark;
    /**
     * 使用注解@Id标注主键。
     */
    @Id
    private String id;

    public User(String name, String remark) {
        this.name = name;
        this.remark = remark;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}