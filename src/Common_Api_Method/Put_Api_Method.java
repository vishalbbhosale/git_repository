package Common_Api_Method;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Put_Api_Method {
	
	public static int responsestatuscode(String baseURI,String Resourse,String Requestbody) {
		RestAssured.baseURI=baseURI;
		
		int statuscode= given().header("Content-Type","application/json").body(Requestbody).when().put("api/users/2").then().extract().statusCode();
		return statuscode;
	}

	
	public static String Responsebody(String baseURI,String Resourse,String Requestbody) {
		RestAssured.baseURI=baseURI;
		
		String Responsebody=given().header("Content-Type","application/json").body(Requestbody).when().put("api/users/2").then().extract().response().asPrettyString();
		return Responsebody;
		
	}
}
