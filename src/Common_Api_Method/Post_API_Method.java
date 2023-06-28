package Common_Api_Method;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class Post_API_Method {
	
	public static int responsestatuscode(String baseURI, String Resourse,String Requestbody) {
	RestAssured.baseURI=baseURI;
	
	int statuscode=given().header("Content-Type","application/json").body(Requestbody).when().post("api/users").then().extract().statusCode();
	return statuscode;
}
	
	
	public static String responsebody(String baseURI,String Resourse,String Requestbody) {
		RestAssured.baseURI=baseURI;
		
		String Responsebody=given().header("Content-Type","application/json").body(Requestbody).when().post("api/users").then().extract().response().asPrettyString();
		return Responsebody;
		
	}
}