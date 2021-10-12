package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.WorksSearchReqeust;
import com.example.demo.servic.UserServic;

@RestController
@RequestMapping("/search")
public class UserController {

	@Autowired
	UserServic servic;

	@GetMapping("/age")
	public ResponseEntity<?> searchByAge(@RequestParam("begin") Optional<Integer> beginAge,
			@RequestParam("end") Optional<Integer> endAge, @RequestParam("skip") Optional<Integer> skipParam,
			@RequestParam("take") Optional<Integer> takeParam) {
		int begin = beginAge.orElse(33);
		int end = endAge.orElse(66);
		int skip = skipParam.orElse(0);
		int take = takeParam.orElse(10);
		return ResponseEntity.ok(servic.findByAge(begin, end, skip, take));
	}

	@GetMapping("/gender")
	public ResponseEntity<?> searchByGender(@RequestParam("gender") Optional<String> gender,
			@RequestParam("skip") Optional<Integer> skipParam, @RequestParam("take") Optional<Integer> takeParam) {
		int skip = skipParam.orElse(0);
		int take = takeParam.orElse(10);
		return ResponseEntity.ok(servic.findByGender(gender.orElse("male"), skip, take));
	}

	@GetMapping("/works")
	public ResponseEntity<?> searchByWorks(@RequestBody WorksSearchReqeust works,
			@RequestParam("skip") Optional<Integer> skipParam, @RequestParam("take") Optional<Integer> takeParam) {
		int skip = skipParam.orElse(0);
		int take = takeParam.orElse(10);
		return ResponseEntity.ok(servic.findByWorks(works.getWorks(), skip, take));
	}
}
