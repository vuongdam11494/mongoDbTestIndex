package com.example.demo.data.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.example.demo.data.enums.Gender;
import com.example.demo.data.enums.Work;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@MongoId(targetType =  FieldType.OBJECT_ID)
	private String id;
	private String name;
	@Indexed(name = "age_index",direction = IndexDirection.ASCENDING)
	private int age;
	private String address;
	@Field(targetType = FieldType.STRING)
	@Indexed(name = "gender_index",direction = IndexDirection.ASCENDING)
	private Gender gender;
	@Field("birth_date")
	private LocalDate birthDate;
	@Field(targetType = FieldType.STRING)
	@Indexed(name = "works_index",direction = IndexDirection.ASCENDING)
	private List<Work> works;

	
}
