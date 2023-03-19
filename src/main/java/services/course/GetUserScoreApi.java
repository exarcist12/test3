package services.course;
import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import dto.course.UserDto;

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
