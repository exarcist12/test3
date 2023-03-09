package services;

import static io.restassured.RestAssured.given;

import dto.User;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UserApi {
  private  static String BASE_URL = System.getProperty("webdriver.base.url");
  private static final String BASE_PATH = "/user";
  private RequestSpecification spec;

  public UserApi(){
    spec = given().baseUri(BASE_URL).contentType(ContentType.JSON);
  }

  public ValidatableResponse createUser(User user){
    return   given(spec).basePath(BASE_PATH).body(user).log().all().when().post().then().log().all();
  }
}
