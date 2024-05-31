package httpsMethods;

import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//given() : pre-reqiuisite
	//headers/cookies/path and query parameters/paylod/Authentication
	//when (): action(http methods)/
	//then(): response validation
	//ststus code/msg/body(response payload)/log()

public class Get_Request 
{
  @Test(priority=1)
  public void singleUserTest()
  {
	  System.out.println("This is single user request!");
	  
	  given()
	      .when()
	         .get("https://reqres.in/api/users/2")
	      .then()
	      .statusCode(200)
	      .body("data.id", equalTo(2)) 
	      .body("data.email", equalTo("janet.weaver@reqres.in"))
	      .body("data.first_name", equalTo("Janet"))
	      .log().body();
	      
	  
  }
  @Test(priority=2)
  public void listOfUsers() 
  {
	  
	  given()
	  
	  .when()
	  .get("https://reqres.in/api/users?page=2")
	  
	  .then()
	  .statusCode(200)
	  .body("page", equalTo(2))
	  .body("data.id[2]", equalTo(9))//single valu validation
	  .body("data.id", hasItems(7,8,9,10,11,12))
	  .body("data.id", hasItems(7,8,9))
	  .body("data.id", hasItems(11,8,12))
	 // .body("data.id", hasItems(7,8,9,10,6))//assertation error
	  
	  //contains()
	  //it is strict in order
	  .body("data.id", contains(7,8,9,10,11,12))
	  //.body("data.id", contains(10,11,12))
	  
	  .log().body();	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
  }
