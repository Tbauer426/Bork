package Bork.Dog;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import Bork.Requirements.Requirements;

public class Dog{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String description;
	//change this to DOB
	private int age;
	private String name;
	//private location location;
	private char sex;
	private long ownerId;
	private String breed;
	private Requirements requirements;
	
	//requirements
	//change this to DOB
	private int ageUpper;
	private int ageDown;
	private char sexReq;
	private long radius;
	private String breedReq;
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getBreedReq() {
		return breedReq;
	}
	public void setBreedReq(String breedReq) {
		this.breedReq = breedReq;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public Requirements getRequirements() {
		return requirements;
	}
	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}
//	public Collection<Long> getDogsImages() {
//		return dogsImages;
//	}
//	public void setDogsImages(Collection<Long> dogsImages) {
//		this.dogsImages = dogsImages;
//	}
//	public Collection<Long> getVisitedBy() {
//		return visitedBy;
//	}
//	public void setVisitedBy(Collection<Long> visitedBy) {
//		this.visitedBy = visitedBy;
//	}
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
	public char getSexReq() {
		return sexReq;
	}
	public void setSexReq(char sexReq) {
		this.sexReq = sexReq;
	}
	public long getRadius() {
		return radius;
	}
	public void setRadius(long radius) {
		this.radius = radius;
	}

}