package services;

import dto.User;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetUserApi {
	private  static String BASE_URL = "https://petstore.swagger.io/v2";

	private RequestSpecification spec;

	public GetUserApi(){
		spec = given()
				.baseUri(BASE_URL)
				.contentType(ContentType.JSON);
	}

	public ValidatableResponse getUser(User user){
		String BASE_PATH = "/user/"+ user.getUsername();
		return   given(spec)
				.basePath(BASE_PATH)
				.log().all()
				.when()
				.get()
				.then()
				.log().all();
	}
}
