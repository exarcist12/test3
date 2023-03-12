package services;

import dto.User;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class DeleteUserApi {
  BaseSpec baseSpec = new BaseSpec();

  private RequestSpecification spec;

  public DeleteUserApi(){
    spec = baseSpec.getSpec();
  }

  public ValidatableResponse deleteUser(User user){
    String basePath = "/user/"+ user.getUsername();
    return   given(spec).basePath(basePath).log().all().when().delete().then().log().all();
  }
}