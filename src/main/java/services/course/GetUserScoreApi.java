package services.course;

import dto.User;
import dto.course.UserDto;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import services.BaseSpec;

import static io.restassured.RestAssured.given;


public class GetUserScoreApi {
  private BaseCourseSpec baseCourseSpec = new BaseCourseSpec();

  private RequestSpecification spec;

  public GetUserScoreApi(){
    spec = baseCourseSpec.getSpec();
  }

  public ValidatableResponse getUserScore(UserDto user){
    String basePath = "/user/get/"+ user.getName();
    return   given(spec).basePath(basePath).log().all().when().get().then().log().all();
  }
}
