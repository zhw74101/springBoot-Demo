package com.springboot.demo.dao;

import com.springboot.demo.pojo.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by zhanghongwei on 2019/12/17.
 */
public interface StudentRepository extends JpaRepository<Students,String> {

    /*
    * repository 继承 JpaRepository 后虽然提供一部分的简单CURD操作，但不能满足所有的业务需求，
    * 有时需要自定义的CURD操作。
    * 自定义有两种方法：根据名字直接解析；使用@Query直接指定查询的sql
    * 在设计update 和delete时需要加 @Modifying 注解
    * */
    Students findByStuName(String stuName);


    /**
     * JPA 的 JPQL
     * 此方法的 @Query 使用了JPA映射的实体类作为查询对象，查询字段也是实体类中的属性
     * @param age
     * @return
     */
    @Query("select s from Students s where s.stuAge = ?1")
    Students findByStuAge(int age);

    /**
     * 原生 sql
     * 此方法的 @Query 使用了原生的sql查询，JPA支持原生sql查询，但是需要在该注解的后面加 nativeQuery = true
     * @param stuName
     * @param stuSex
     * @return
     */
    @Query(value = "select s.* from students s where s.stu_name = :stuName and s.stu_sex = :stuSex",nativeQuery = true)
    Students findByStuNameAndStuSex(@Param("stuName")String stuName, @Param("stuSex")String stuSex);

}
