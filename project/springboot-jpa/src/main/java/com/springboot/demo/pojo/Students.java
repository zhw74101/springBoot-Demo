package com.springboot.demo.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhanghongwei on 2019/12/17.
 * @Entity 表示该类为 jpa 的一个实体类，与数据库中的某张表对应
 *
 */
@Entity
@Table(name = "students")
public class Students implements Serializable{

    /*
    * 学生表编号。
    * @Id 表示生成的该字段为表中的主键，类中只能有一个此注解
    * @GenericGenerator 设置主键的生成策略，name属性为该生成策略的名字，strategy属性为生成策略，目前采用UUID，随机字符串
    * @GeneratedValue 指定其生成策略，生成策略已经在之前设置，直接引用即可。
    * */
    @Id
    @GenericGenerator(name = "idGenerator" , strategy = "uuid.hex")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "stu_name",unique = true,nullable = true,length = 64)
    private String stuName;

    @Column(name = "stu_sex",unique = true,nullable = true,length = 8)
    private String stuSex;

    @Column(name = "stu_age",unique = true,nullable = true,length = 4)
    private int stuAge;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public Students() {
    }

    public Students(String stuName, String stuSex, int stuAge) {
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
    }
}
