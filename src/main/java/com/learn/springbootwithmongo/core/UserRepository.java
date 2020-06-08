package com.learn.springbootwithmongo.core;

/**
 * created by shaochong.com on 12:04 下午 2020/6/4
 */
/**
 * 由于继承了MongoRepository接口，所以能够直接使用基本的数据库操作方法，如save()方法,find()方法等。
 * 如果想自定义方法，需要按照类似于JPA的方式对方法进行命名，传参必须和文档包含的字段名相同（和实体类也相同）。这样的方法就能直接使用
 */

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    // 自定义的查询方法
    public User findByName(String name);

    public Page<User> findByName(String name, Pageable pageable);

    /**
     * 其中value是查询的条件
     * ？0这个是占位符，对应方法中参数中的第一个参数，如果对应的是第二个参数则为？1。
     * fields是我们指定的返回字段，其中id是自动返回的
     */
    @Query(value="{'name':?0,'remark':?1}",fields="{'name':1,'remark':1}")
    public Page<User> queryByNameAndRemark(String name, String remark, Pageable pageable);
}
