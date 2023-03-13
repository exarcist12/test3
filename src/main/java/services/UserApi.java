package services;

import static io.restassured.RestAssured.given;

import dto.User;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UserApi {

  private BaseSpec baseSpec = new BaseSpec();
  private static final String BASE_PATH = "/user";
  private RequestSpecification spec;

  public UserApi(){
    spec = baseSpec.getSpec();
  }

  public ValidatableResponse createUser(User user){
    return   given(spec).basePath(BASE_PATH).body(user).log().all().when().post().then().log().all();
  }
}
