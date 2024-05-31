package httpsMethods;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

//given() : pre-reqiuisite
	//headers/cookies/path and query parameters/paylod/Authentication
	//when (): action(http methods)/
	//then(): response validation
	//ststus code/msg/body(response payload)/log()

import org.testng.annotations.Test;

public class Update_Delete_Request {
  @Test
  public void UpdateUser() 
  {
	  //Request payload
	  PojoData data=new PojoData();
	  data.setName("Parshwa");
	  data.setJob("Engg");
	  
	  given()
	  .contentType("application/json")
	  
	  .when()
	  .put("https://reqres.in/api/users/2")
	  
	  .then()
	  .statusCode(200)
	  .log().body();
	  
	 
  }
  @Test
  
  public void deleteUser()
  {
	given()
	.when().delete("https://reqres.in/api/users/2")
	
	.then()
	.statusCode(204)
	.log().all();
  }
}
