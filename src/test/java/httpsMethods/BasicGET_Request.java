package httpsMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicGET_Request {
  @Test
  public void SingleUserTest () 
  {	//response is 
	  Response res=RestAssured.get("https://reqres.in/api/users/2");
	  int statuscode=res.getStatusCode();
	  //validation
	  Assert.assertEquals(statuscode, 200,"Status code is not matching!");
	  System.out.println("Status code for current GET request is:  "+statuscode );
	  
	  System.out.println(res.getSessionId());
	  System.out.println(res.getStatusLine());
	  System.out.println(res.getTime());
	  System.out.println(res.getBody().asString());//in String of json
	  System.out.println("**************************");
	  System.out.println(res.getBody().toString());//in Object
	  
  }
}
