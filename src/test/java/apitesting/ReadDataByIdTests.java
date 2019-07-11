package apitesting;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ReadDataByIdTests {
	
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
	public void readDataByIdTest() {
		when().
		  get("/peps/5d27417e17b9b506d14f30e3").
		then().
		spec(JsonContentTypeAndStatusCodeCheck).
		body("country", equalTo("India")).
		body("createdAt", equalTo("2019-07-11T14:02:38.202731")).
		body("id", equalTo("5d27417e17b9b506d14f30e3")).
		body("name", equalTo("Sai")).
		body("position", equalTo("test")).
		body("risk", equalTo("2")).
		body("yob", equalTo("1985"));
		
		
	}
	
}
