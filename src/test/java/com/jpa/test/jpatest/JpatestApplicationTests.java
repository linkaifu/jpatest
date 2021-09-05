package com.jpa.test.jpatest;

import com.jpa.test.jpatest.dao.UserDao;
import com.jpa.test.jpatest.domain.Userinfo;
import javassist.runtime.Desc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class JpatestApplicationTests {

	@Autowired
	UserDao dao;
	@Test
	void contextLoads() {
		Userinfo info = new Userinfo();
		info.setUsername("heihei");
		info.setSex("male");
		dao.save(info);
		System.out.println("添加成功");
	}

	@Test
	void getUser(){
		Iterable<Userinfo> all = dao.findAll();
		for(Userinfo user : all){
			System.out.println(user.getUsername());
		}
	}

	@Test
	void getPageUser(){
		Sort sort = Sort.by(Sort.Direction.DESC,"username","sex","id");
		Pageable pageablesort2 = PageRequest.of(0,3,Sort.Direction.ASC,"username");
		Pageable pageablesort = PageRequest.of(0,3,sort);
		Pageable pageable = PageRequest.of(0,3);
		Page<Userinfo> all = dao.findAll(pageable);
		for(Userinfo user : all){
			System.out.println(user.getUsername());
		}
	}

	@Test
	void getPageSort(){
		Iterable<Userinfo> all = dao.findAll(Sort.by("username","id","sex"));
		for(Userinfo user : all){
			System.out.println(user.getUsername());
		}
	}

	@Test
	void getUserByTowCondition(){
		Iterable<Userinfo> userByUsernameAndSex = dao.getUserByUsernameAndSex("haha", "female");
		for(Userinfo user:userByUsernameAndSex){
			System.out.println(user.getUsername());
		}
	}
// 增加一个提交的注释
	@Test
	void getUserByMoreThanTwo(){
		Iterable<Userinfo> userByIdAndUsernameAndSex = dao.getUserByIdAndUsernameAndSex(1L, "haha", "male");
		for(Userinfo user:userByIdAndUsernameAndSex){
			System.out.println(user.getUsername());
			System.out.println("aaa");
		}
	}
}
