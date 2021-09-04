package com.jpa.test.jpatest.dao;

import com.jpa.test.jpatest.domain.Userinfo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<Userinfo,Long> {
    Iterable<Userinfo> getUserByUsernameAndSex(String username,String sex);

    Iterable<Userinfo> getUserByIdAndUsernameAndSex(Long id,String username,String sex);
}

