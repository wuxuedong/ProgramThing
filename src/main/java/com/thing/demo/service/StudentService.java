package com.thing.demo.service;

import com.thing.demo.entity.Student;
import com.thing.demo.mapper.StudentMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class StudentService {


    private PlatformTransactionManager transactionManager;

    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper,PlatformTransactionManager pftam) {
        this.studentMapper = studentMapper;
        transactionManager = pftam;
    }

    public void insert(Student student) {
        //创建事物
        TransactionStatus transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            studentMapper.insert(student);
            int i = 3/0;
            studentMapper.insert(student);
            //提交事物
            transactionManager.commit(transaction);
        }catch (DataAccessException e) {
            //回滚事物
            transactionManager.rollback(transaction);
        }
    }
}
