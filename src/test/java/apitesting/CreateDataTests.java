package apitesting;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.text.MatchesPattern.matchesPattern;
import static org.junit.Assert.assertThat;

public class CreateDataTests {
	
	/* setting baseURI here */	
	
	@BeforeClass
	public static void setBaseUri () {

    	RestAssured.baseURI = "http://ec2-34-251-162-89.eu-west-1.compute.amazonaws.com";
	  }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void createDataWithAllMandatoryFieldsTest()
	{ 
		
	 /* creating json object with json body(with all mandatory fields as parameters) to create post request */
		 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("name", "test");
	 requestParams.put("country", "India");
	 requestParams.put("yob", "1985");
	 requestParams.put("risk", "5");
	 requestParams.put("position",  "test");
	 
	 /* storing response of post request in response */
	 
	 Response response = 
	 given().
	  header("content-type", "application/json").
	  body(requestParams.toString()). 
	 when().
	  post("/peps");
	 
	 ResponseBody body = response.getBody();
	 
	 String bodyStringValue = body.asString();
	 
	 /* making some assertions to check whether the post request is success or not */
	 
	 Assert.assertTrue(bodyStringValue.contains("Entity created successfully!"));
	 
	 JsonPath jsonPathEvaluator = response.jsonPath();
	
	 String message = jsonPathEvaluator.get("message");
	
	 Assert.assertTrue(message.contentEquals("Entity created successfully!"));
		 
	 String id = jsonPathEvaluator.get("id");
	
	 assertThat(id, matchesPattern("^[a-z0-9]*$"));
	
	 int statusCode = response.getStatusCode();
	
	 Assert.assertEquals(statusCode, 201);
	 
	 /* making sure that data created is appearing in the list */

	 when().
	  get("/peps").
	 then().
	  assertThat().
  	  body("[0].id",equalTo(id));
		
	
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithNoName()
	{ 
		
		 /* creating json object with json body(with no name) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("country", "India");
		 requestParams.put("yob", "1985");
		 requestParams.put("risk", "5");
		 requestParams.put("position",  "test");
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 JsonPath jsonPathEvaluator = response.jsonPath();
		
		 String message = jsonPathEvaluator.get("message");
		 
		 /* making some assertions to check whether the post request is failed or not */
		 
		 Assert.assertEquals("Invalid request - missing parameters", message);
		
		 int statusCode = response.getStatusCode();
		
		 Assert.assertEquals(statusCode, 400);
		 
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithNoCountry()
	{ 
		
		 /* creating json object with json body(with no country) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "test");
		 requestParams.put("yob", "1985");
		 requestParams.put("risk", "5");
		 requestParams.put("position",  "test");
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 JsonPath jsonPathEvaluator = response.jsonPath();
		
		 String message = jsonPathEvaluator.get("message");
		 
		 /* making some assertions to check whether the post request is failed or not */
		 
		 Assert.assertEquals("Invalid request - missing parameters", message);
		
		 int statusCode = response.getStatusCode();
		
		 Assert.assertEquals(statusCode, 400);
		 
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithNoYob()
	{ 
		
		 /* creating json object with json body(with no yob) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "test");
		 requestParams.put("country", "India");
		 requestParams.put("risk", "5");
		 requestParams.put("position",  "test");
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 JsonPath jsonPathEvaluator = response.jsonPath();
		
		 String message = jsonPathEvaluator.get("message");
		 
		 /* making some assertions to check whether the post request is failed or not */
		 
		 Assert.assertEquals("Invalid request - missing parameters", message);
		
		 int statusCode = response.getStatusCode();
		
		 Assert.assertEquals(statusCode, 400);
		 
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithNoRisk()
	{ 
		
		 /* creating json object with json body(with no risk) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "test");
		 requestParams.put("country","India");
		 requestParams.put("yob", "1985");
		 requestParams.put("position",  "test");
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 JsonPath jsonPathEvaluator = response.jsonPath();
		
		 String message = jsonPathEvaluator.get("message");
		 
		 /* making some assertions to check whether the post request is failed or not */
		
		 Assert.assertEquals("Invalid request - missing parameters", message);
		 
		 int statusCode = response.getStatusCode();
		
		 Assert.assertEquals(statusCode, 400);
		 
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithNoPosition()
	{ 
		
		 /* creating json object with json body(with no position) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "test");
		 requestParams.put("country","India");
		 requestParams.put("yob", "1985");
		 requestParams.put("risk", "5");
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 JsonPath jsonPathEvaluator = response.jsonPath();
		 
		 String message = jsonPathEvaluator.get("message");
		 
		 /* making some assertions to check whether the post request is failed or not */
		
		 Assert.assertEquals("Invalid request - missing parameters", message);
		 
		 int statusCode = response.getStatusCode();
		
		 Assert.assertEquals(statusCode, 400);
				 
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithEmptyStringsForMandatoryParameters()
	{ 
		
		 /* creating json object with json body(with empty strings) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "");
		 requestParams.put("country","");
		 requestParams.put("yob", "");
		 requestParams.put("risk", "");
		 requestParams.put("position", "");
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 int statusCode = response.getStatusCode();
		 
		 /* making an assertion to check whether the post request is failed or not */
		
		 Assert.assertNotEquals(statusCode, 201);
				 
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithNullAsMandatoryParameters()
	{ 
		
		 /* creating json object with json body(with no position) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", null);
		 requestParams.put("country", null);
		 requestParams.put("yob", null);
		 requestParams.put("risk", null);
		 requestParams.put("position", null);
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 int statusCode = response.getStatusCode();
		 
		 /* making an assertion to check whether the post request is failed or not */
		
		 Assert.assertNotEquals(statusCode, 201);
				 
	}
	
    @SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithInvalidCountryAsParameter()
	{ 
		
		 /* creating json object with json body(with invalid country parameter) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "test");
		 requestParams.put("country", "hdyb1532£$%^");
		 requestParams.put("yob", "1985");
		 requestParams.put("risk", "5");
		 requestParams.put("position",  "test");
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 int statusCode = response.getStatusCode();
		 
		 /* making an assertion to check whether the post request is failed or not */
		
		 Assert.assertNotEquals(statusCode, 201);
				 
	}
    
    @SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithInvalidYobAsParameter()
	{ 
		
		 /* creating json object with json body(with invalid yob parameter) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "test");
		 requestParams.put("country", "India");
		 requestParams.put("yob", "abcd/xse/20/*&^%/10/2011");
		 requestParams.put("risk", "5");
		 requestParams.put("position",  "test");
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 int statusCode = response.getStatusCode();
		 
		 /* making an assertion to check whether the post request is failed or not */
		
		 Assert.assertNotEquals(statusCode, 201);
				 
	}
    
    @SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithOutOfRangeRiskParameter()
	{ 
		
		 /* creating json object with json body(with invalid risk as parameter) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "test");
		 requestParams.put("country", "India");
		 requestParams.put("yob", "1985");
		 requestParams.put("risk", "7");
		 requestParams.put("position",  "test");
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 int statusCode = response.getStatusCode();
		 
		 /* making an assertion to check whether the post request is failed or not */
		
		 Assert.assertNotEquals(statusCode, 201);
				 
	}
    
    @SuppressWarnings({ "unchecked" })
	@Test
	public void createDataWithStringAsInvalidRiskParameter()
	{ 
		
		 /* creating json object with json body(with invalid risk as parameter) to create post request */
			 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "test");
		 requestParams.put("country", "India");
		 requestParams.put("yob", "1985");
		 requestParams.put("risk", "7");
		 requestParams.put("position",  "test");
		 
		 /* storing response of post request in response */
		 
		 Response response = 
		 given().
		  header("content-type", "application/json").
		  body(requestParams.toString()). 
		 when().
		  post("/peps");
		 
		 int statusCode = response.getStatusCode();
		 
		 /* making an assertion to check whether the post request is failed or not */
		
		 Assert.assertNotEquals(statusCode, 201);
				 
	}
	
	
}
