package com.example.demo.servic;

import java.util.List;

import com.example.demo.data.model.User;

public interface UserServic {

	List<User> findByAge(int begin, int end, int skip, int take);
	List<User> findByGender(String gender, int skip, int take);
	List<User> findByWorks(List<String> works, int skip, int take);
	
}
