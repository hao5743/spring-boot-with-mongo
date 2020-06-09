package com.learn.springbootwithmongo.core2;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 查询全部
     */
    public List<Account> list() {
        List<Account> accounts = mongoTemplate.findAll(Account.class);
        for(Account account: accounts) {
            System.out.println("account: " + account.toString());
        }
        return accounts;
    }

    /**
     * 按id查询
     */
    public Account findAccountById(String id) {
        Account account = mongoTemplate.findById(id, Account.class);
        return account;
    }

    /**
     * 高级查询
     */
    public List<Account> query(Account account) {

        // 查询调条件
        Criteria criteria = Criteria
                .where("account").is(account.getAccount())
                .and("name").is(account.getName())
                .and("companyName").is(account.getCompanyName());

        Query query = new Query();
        query.addCriteria(criteria);
        // 排序
        query.with(Sort.by(
                Sort.Order.asc("account"),
                Sort.Order.desc("name")
        ));
        // 分页
        query.skip(0);
        query.limit(10);
        List<Account> accounts = mongoTemplate.find(query, Account.class);
        return accounts;
    }

    /**
     * 高级查询 - 方式2
     */
    public List<Account> query2(Account account) {
        // 查询条件
        Document queryObject = new Document();
        if (account.getAccount() != null) {
            queryObject.put("account", account.getAccount());
        }
        if (account.getName() != null) {
            queryObject.put("name", account.getName());
        }
        if (account.getCompanyName() != null) {
            queryObject.put("companyName", account.getCompanyName());
        }
        // 指定返回值
        Document fieldsObject = new Document();
        fieldsObject.put("name", true);
        fieldsObject.put("account", true);
        Query query = new BasicQuery(queryObject, fieldsObject);
        // 排序
        query.with(Sort.by(
                Sort.Order.asc("account"),
                Sort.Order.desc("name")
        ));
        // 分页
        query.skip(0);
        query.limit(100);
        return mongoTemplate.find(query, Account.class);
    }

    /**
     * 修改
     */
    public void updateAccount(Account account) {
        Query query = new Query(Criteria.where("id").is(account.getId()));
        Update update = new Update();
        update.set("name", account.getName());
        update.set("account", account.getAccount());
        update.set("companyName", account.getCompanyName());
        UpdateResult result = mongoTemplate.upsert(query, update, Account.class);
        long count = result.getModifiedCount();
        if (count > 0) {
            System.out.println("update ok!" + count);
        }
        System.out.println("update no " + count);
    }

    /**
     * 删除
     */
    public void deleteAccount(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult result = mongoTemplate.remove(query, Account.class);
        long count = result.getDeletedCount();
        if (count > 0) {
            System.out.println("delete ok!" + count);
        }
        System.out.println("delete no! " + count);
    }

    /**
     * 新增
     */
    public void addAccount(Account account) {
        Account insert = mongoTemplate.insert(account);
        System.out.println("add ok " + insert);
    }
}
