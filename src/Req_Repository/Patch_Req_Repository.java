package Req_Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Api_Method.Common_Uitility_Method;

public class Patch_Req_Repository {
	
	public static String baseURI() {
		String BaseURI="https://reqres.in/";
		return BaseURI;
	}
	

	public static String Patch_Resourse() {
		String Patch_Resourse="api/users/2";
		return Patch_Resourse;
		
	}
		
	public static String Patch_TC1() throws IOException {
		ArrayList<String> Req_Data= Common_Uitility_Method.ReadDataExcel("PatchApi", "TC1");
	    System.out.println(Req_Data);
		String Req_name=Req_Data.get(0);
		String Req_job=Req_Data.get(1);
		
		String Requestbody="{\r\n"
				+ "    \"name\": \""+Req_name+"\",\r\n"
				+ "    \"job\": \""+Req_job+"\"\r\n"
				+ "}";
		return Requestbody;
	}
	

}
