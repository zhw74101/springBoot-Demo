package com.springboot.demo.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * Created by zhanghongwei on 2019/12/17.
 * Repository<T, ID> 通过继承 Repository<T, ID> 实现自定义的 repository 接口，
 * 可以自定义暴露CURD的相关操作
 * 这次实例测试中不使用自定义
 */
@NoRepositoryBean
public interface BaseRespository<T, ID> extends Repository<T, ID> {
    <S extends T> S save(S var1);

    <S extends T> Iterable<S> saveAll(Iterable<S> var1);

    Optional<T> findById(ID var1);

    boolean existsById(ID var1);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> var1);

    long count();

    void deleteById(ID var1);

    void delete(T var1);

    void deleteAll(Iterable<? extends T> var1);

    void deleteAll();
}
