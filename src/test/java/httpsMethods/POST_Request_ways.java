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

public class POST_Request_ways 
	{
  @Test
  public void PostWithMap () 
  {
	  //need to creat request payload
	  HashMap<String,Object>data=new HashMap<String,Object>();
	  data.put("name", "Aditya");
	  data.put("Job", "Automation Eng");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  
	  .when()
	  .post("https://reqres.in/api/users")
	  
	  .then()
	  .body("name",equalTo("Aditya"))
	  .statusCode(201)
	  .log().body();
	  
	  System.out.println("New User Created using HashMap");  
	  
	  
     }
  
  @Test
  public void  pojoWay() 
  {
	 //request Payload
	  PojoData data= new PojoData();
	  data.setName("Akanksha");
	  data.setJob("QA");
	  
	  
	  
	  given()
	  
	  .contentType("application/json")
	  .body(data)
	  
	  .when()
      .post("https://reqres.in/api/users")
	  
	  .then()
	  .statusCode(201)
	  .body("name",equalTo("Akanksha"))
	  .log().body();
	  
  }
}
