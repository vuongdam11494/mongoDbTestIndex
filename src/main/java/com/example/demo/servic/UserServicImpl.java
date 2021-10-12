package com.example.demo.servic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.data.enums.Gender;
import com.example.demo.data.enums.Work;
import com.example.demo.data.model.User;
import com.example.demo.data.repository.UserRepo;

@Service
public class UserServicImpl implements UserServic {

	@Autowired
	UserRepo userRepo;
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<User> findByAge(int begin, int end, int skip, int take) {
		Criteria criteria = Criteria.where("age").gte(begin).lte(end);
		Query query = Query.query(criteria);
		query.limit(take);
		//sử dụng tương tự phân trang
		query.skip((skip*take)-take);
		return mongoTemplate.find(query, User.class);
	}
	
	@Override
	public List<User> findByGender(String gender, int skip, int take) {
		Criteria criteria = Criteria.where("gender").is(Gender.valueOf(gender.toUpperCase()));
		Query query = Query.query(criteria);
		query.limit(take);
		//sử dụng tương tự phân trang
		query.skip((skip*take)-take);
		return mongoTemplate.find(query, User.class);
	}
	
	@Override
	public List<User> findByWorks(List<String> works, int skip, int take) {
		Criteria criteria = Criteria.where("works").all(works);
		Query query = Query.query(criteria);
		query.limit(take);
		//sử dụng tương tự phân trang
		query.skip((skip*take)-take);
		return mongoTemplate.find(query, User.class);
	}
}
