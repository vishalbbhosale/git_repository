package Test_cases;
import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Api_Method.Post_API_Method;
import  Req_Repository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;
public class Post_TC1 {
	@Test

	
	public static void extractor() throws IOException {
		for(int i=0;i<5;i++){
		int statuscode = Post_API_Method.responsestatuscode(Post_Req_Repository.baseURI(), Post_Req_Repository.Post_Resourse(), Post_Req_Repository.post_TC1());
			System.out.println(statuscode);
			
			
			if(statuscode==201) {
					
			String Responsebody= Post_API_Method.responsebody(Post_Req_Repository.baseURI(),Post_Req_Repository.Post_Resourse(),Post_Req_Repository.post_TC1());
			System.out.println(Responsebody);
			
			String Requestbody=Post_Req_Repository.post_TC1();
			
			validator(Requestbody,Responsebody);
			
		break;}
		else
		{
			System.out.println("status code is invalid");
		}
		}
	}
		public static void validator(String Requestbody,String Responsebody) {
			
			
			//parse req body
			JsonPath jspRequest=new JsonPath(Requestbody);
			String Req_name=jspRequest.getString("name");
			String Req_job=jspRequest.getString("job");
			LocalDateTime currentdate=LocalDateTime.now();
			String expecteddate=currentdate.toString().substring(0,11);
			
			//parse response body
			JsonPath jspResponse=new JsonPath(Responsebody);
			String Res_name=jspResponse.getString("name");
			String Res_job=jspResponse.getString("job");
			String Res_createdAt=jspResponse.getString("createdAt");
			Res_createdAt=Res_createdAt.substring(0,11);
			
			
			//validate response parameter
			Assert.assertEquals(Res_name, Req_name);
			Assert.assertEquals(Res_job, Req_job);
			Assert.assertEquals(Res_createdAt, expecteddate);
		
		}
		
		
			
		
	}

