package httpsMethods;

import org.testng.Assert;
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
public class BDD_GET_Request
{
	
  @Test(priority=1)
  public void get_GoogleTest() 
  {
	given()
	
	.when()
	.get("https://www.google.co.in/")	  
	
	.then()
	.statusCode(200)
	//.log().all();
	.log().cookies();
	  
	  
	  
  }

  @Test(priority=2)
  public void get_GoogleTest2() 
  {
	Response res=given()
	
	              .when()
	                 .get("https://www.google.co.in/");	  
	
	int actcode=res.getStatusCode();
	Assert.assertEquals(actcode, 200,"Status code not matched!");
	System.out.println("Status code matched: "+actcode);
	  
	  
	  
  }
  
}




