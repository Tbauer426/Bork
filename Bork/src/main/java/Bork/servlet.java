package Bork;

//import java.security.NoSuchAlgorithmException;
//import java.security.Principal;
//import java.security.SecureRandom;
//import java.security.spec.InvalidKeySpecException;
//import java.util.Arrays;
//import java.util.Base64;
import java.util.Collection;
//import java.util.Optional;
//
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
//import java.util.Arrays;
//import java.util.Base64;
//import java.security.SecureRandom;
//
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.PBEKeySpec;

//import com.google.common.base.Objects;
//import com.maxmind.geoip2.record.Location;


import Bork.Dog.Dog;
import Bork.Dog.DogRepo;
import Bork.Image.Image;
import Bork.Image.ImageRepo;
import Bork.Requirements.Requirements;
import Bork.User.User;
import Bork.User.UserRepo;

@Controller
public class servlet{
	@Autowired
	private DogRepo dogRepo;
	@Autowired 
	private ImageRepo imageRepo;
	@Autowired
	private UserRepo userRepo;
	
	@RequestMapping(value = "/Register_User", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> registerUser(User u) {
		User temp = userRepo.findByUserName(u.getUserName());
		if(temp.getUserName() == u.getUserName() /*&& Do something to compare passwords*/) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{userId}/Register_Dog", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> addDog(@PathVariable("userId") Long id, Dog dog) {
		Collection<Dog> temp = dogRepo.findDogWhereOwnerIdIsEqualToId(id);
	
		if(temp.size() < 4) {
			dogRepo.save(dog);
			return new ResponseEntity<>(dog, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{dogId}/Add_Image", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> addImage(@PathVariable("dogId") Long id, Image image) {
		Collection<Image> temp = imageRepo.findImageWhereUserIdIsEqualToId(id);
		if(temp.size() < 6) {
			imageRepo.save(image);
			return new ResponseEntity<>(image, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{dogId}/Remove_Image", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> removeImage(@PathVariable("dogId") Long id, Image image) {
		Image temp = imageRepo.findImageById(id);
		if(temp == null) {
			imageRepo.delete(image);
			return new ResponseEntity<>(image, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//add requirement method
	@RequestMapping(value = "/{dogId}/Get_Requirements", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getDogsInRequirements(@PathVariable("dogId") Long id, @RequestBody Dog dog, @RequestBody User user, @RequestBody Requirements requirements) {
		Collection<Dog> temp = dogRepo.findByRequirements(dog.getAgeUpper(), dog.getAgeDown(), 
				dog.getSexReq(), dog.getBreedReq(), user.getLatitude() + dog.getRadius(), 
				user.getLatitude() - dog.getRadius(), user.getLongitude() + dog.getRadius(), user.getLongitude() - dog.getRadius());
		
		if(temp != null) {
			return new ResponseEntity<>(temp, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{dogId}/Set_Requirements", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> setRequirents(@PathVariable("dogId") Long id, @RequestBody Dog dog) {
		Dog temp = dogRepo.findDogById(id);
		
		if(temp != null) {
			dogRepo.save(dog);
			return new ResponseEntity<>(dog, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//all of this here is just for encryption
//	public boolean comparePasswords(String password, String key, String salt) {
//		 Optional<String> optEncrypted = hashPassword(password, salt);
//		 if (!optEncrypted.isPresent()) return false;
//		 return optEncrypted.get().equals(key);
//	}
//	
//	private static final int ITERATIONS = 65536;
//	private static final int KEY_LENGTH = 512;
//	private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
//	
//	private static final SecureRandom RAND = new SecureRandom();
//	
//	public static Optional<String> generateSalt (final int length) {
//
//	    if (length < 1) {
//	      System.err.println("error in generateSalt: length must be > 0");
//	      return Optional.empty();
//	    }
//
//	    byte[] salt = new byte[length];
//	    RAND.nextBytes(salt);
//
//	    return Optional.of(Base64.getEncoder().encodeToString(salt));
//	  }
//
//	private static Optional<String> hashPassword (String password, String salt) {
//
//	char[] chars = password.toCharArray();
//    byte[] bytes = salt.getBytes();
//
//    PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);
//
//    Arrays.fill(chars, Character.MIN_VALUE);
//
//    try {
//      SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
//      byte[] securePassword = fac.generateSecret(spec).getEncoded();
//      return Optional.of(Base64.getEncoder().encodeToString(securePassword));
//
//    } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
//      System.err.println("Exception encountered in hashPassword()");
//      return Optional.empty();
//
//    } finally {
//      spec.clearPassword();
//    }
//  }
	
}