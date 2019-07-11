package apitesting;

import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

public class ReadDataTests {
	
	public static ResponseSpecBuilder builder;
	public static ResponseSpecification JsonContentTypeAndStatusCodeCheck;
	
	
	/* setting baseURI here */	
	
	@BeforeClass
	public static void setBaseUri () {

    	RestAssured.baseURI = "http://ec2-34-251-162-89.eu-west-1.compute.amazonaws.com";
	  }
	
	/*  Setting expected json response spec here using builder for code reusability */	
	
	@BeforeClass
    public static void setupJSONResponseSpecBuilder()
    {
        builder = new ResponseSpecBuilder();
        
        builder.expectStatusCode(200);
        
        builder.expectContentType(ContentType.JSON);
        
        JsonContentTypeAndStatusCodeCheck = builder.build();
    }
	
	@Test
	public void readDataRequestTest() {
		when().
		  get("/peps").
		  
		/* Checking if the get request is working by content type and status code */  

		then().
		  spec(JsonContentTypeAndStatusCodeCheck);
						
	}
	
		
	@Test
	public void readLatestListOfFiveTest() {
		Response response = 
		when().
		  get("/peps");

		int size = response.jsonPath().getList("id").size();
		
		/* making an assertion to check is the list size is 5 */
	
		Assert.assertEquals("Checking for latest list of five politicians", 5, size);
						
	}
	
	
	
	@Test
	public void readDataListTest() {
		String pattern = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{6}$";
	//	Pattern r = Pattern.compile(pattern);
		
		when().
		  get("/peps").
		then().
		
		/* making assertions to check all the elements in the list are displayed as per their data type and mandatory */
		
		  assertThat().
		  
		  /* Elements in first entity in the list */
		  
		  body("[0].country", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[0].createdAt", matchesPattern(pattern)).
		  body("[0].id", matchesPattern("^[a-z0-9]*$")).
		  body("[0].name", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[0].position", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[0].risk", matchesPattern("^[1-5]*$")).
		  body("[0].yob", matchesPattern("^[0-9]*$")).
		
		/* Elements in second entity in the list */
		  
		  body("[1].country", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[1].createdAt", matchesPattern(pattern)).
		  body("[1].id", matchesPattern("^[a-z0-9]*$")).
		  body("[1].name", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[1].position", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[1].risk", matchesPattern("^[1-5]*$")).
		  body("[1].yob", matchesPattern("^[0-9]*$")).
		  
        /* Elements in third entity in the list */
		  
		  body("[2].country", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[2].createdAt", matchesPattern(pattern)).
		  body("[2].id", matchesPattern("^[a-z0-9]*$")).
		  body("[2].name", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[2].position", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[2].risk", matchesPattern("^[1-5]*$")).
		  body("[2].yob", matchesPattern("^[0-9]*$")).
		  
       /* Elements in fourth entity in the list */
		  
		  body("[3].country", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[3].createdAt", matchesPattern(pattern)).
		  body("[3].id", matchesPattern("^[a-z0-9]*$")).
		  body("[3].name", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[3].position", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[3].risk", matchesPattern("^[1-5]*$")).
		  body("[3].yob", matchesPattern("^[0-9]*$")).
		  
       /* Elements in first entity in the list */
		  
		  body("[4].country", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[4].createdAt", matchesPattern(pattern)).
		  body("[4].id", matchesPattern("^[a-z0-9]*$")).
		  body("[4].name", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[4].position", matchesPattern("^[a-zA-Z0-9]*$")).
		  body("[4].risk", matchesPattern("^[1-5]*$")).
		  body("[4].yob", matchesPattern("^[0-9]*$"));
		

				
	}



}
