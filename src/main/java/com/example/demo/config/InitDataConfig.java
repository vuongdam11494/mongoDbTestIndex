package com.example.demo.config;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.example.demo.data.enums.Gender;
import com.example.demo.data.enums.Work;
import com.example.demo.data.model.User;
import com.example.demo.data.repository.UserRepo;

@Component
public class InitDataConfig implements CommandLineRunner {

	@Autowired
	UserRepo userRepo;

	@Override
	public void run(String... args) throws Exception {

		if (userRepo.findAll(PageRequest.of(0, 1)).getSize() == 0 || userRepo.findAll(PageRequest.of(0, 1)).isEmpty()) {
			for (int i = 0; i < 10000000; i++) {
				User user = new User();
				user.setAddress("xxx");
				user.setAge(ThreadLocalRandom.current().nextInt(10, 80));
				user.setBirthDate(LocalDate.of(2021 - user.getAge(), ThreadLocalRandom.current().nextInt(1, 12),
						ThreadLocalRandom.current().nextInt(1, 29)));
				user.setGender(Gender.valueOf(Math.random() < 0.5 ? "MALE" : "FEMALE"));
				user.setName("user" + (i + 1));
				user.setWorks(renderListWork());
				System.out.println(userRepo.save(user));
			}
		}

	}
	public List<Work> renderListWork(){
		Map<Integer, Work> mapWorks = new HashMap<Integer, Work>();
		int j = 0;
		int size = (int) (Math.random() * 9)+1;
		while ( j < size) {
			int rdIdx = ThreadLocalRandom.current().nextInt(25);
			if(!mapWorks.containsKey(rdIdx)) {
				j++;
				mapWorks.put(rdIdx, Work.values()[rdIdx]);
			}
			
		}
		return mapWorks.entrySet().stream().map((e)->{
			return e.getValue();
		}).collect(Collectors.toList());
	}
}
