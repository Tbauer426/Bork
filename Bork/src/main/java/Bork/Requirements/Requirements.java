package Bork.Requirements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;


public class Requirements{

	private long dogId;
	
	private String description;
	//change this to DOB
	private int ageUpper;
	private int ageDown;
	private char sex;
	private long radius;
	
	public long getDogId() {
		return dogId;
	}
	public void setDogId(long dogId) {
		this.dogId = dogId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAgeUpper() {
		return ageUpper;
	}
	public void setAgeUpper(int ageUpper) {
		this.ageUpper = ageUpper;
	}
	public int getAgeDown() {
		return ageDown;
	}
	public void setAgeDown(int ageDown) {
		this.ageDown = ageDown;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public long getRadius() {
		return radius;
	}
	public void setRadius(long radius) {
		this.radius = radius;
	}
}