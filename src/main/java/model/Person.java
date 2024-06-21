package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String id;
	private int age;
	private String phoneNumbers;
}