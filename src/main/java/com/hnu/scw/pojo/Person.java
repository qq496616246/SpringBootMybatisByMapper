package com.hnu.scw.pojo;


/**
 * @ Author     ：scw
 * @ Date       ：Created in 下午 9:31 2018/6/13 0013
 * @ Description：定义一个‘人’的实体bean
 * @ Modified By：
 * @Version: $version$
 */
public class Person {
    private Integer id;
    private String name ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
