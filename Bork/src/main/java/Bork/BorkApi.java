package Bork;

import retrofit.http.GET;
import retrofit.http.POST;

public interface BorkApi{
	@POST("/Register_User")
	public Void addUser();
	
	@POST("/{userId}/Register_Dog")
	public Void addDog();
	
	@POST("/{dogId}/Add_Image")
	public Void addImage();
	
	@GET("/{dogId}/Remove_Image")
	public Void removeImage();
	
	@POST("/{dogId}/Set_Requirements")
	public Void setImage();
	
	//Make requirements object
	@GET("/{dogId}/Get_Requirements")
	public Void getRequirements();
}