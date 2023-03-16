package services.course;

import dto.course.UserDto;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;


public class GetAllUsersApi {
  private BaseCourseSpec baseCourseSpecSpec = new BaseCourseSpec();

  private RequestSpecification spec;

  public GetAllUsersApi(){
    spec = baseCourseSpecSpec.getSpec();
  }

  public ValidatableResponse getUsers(List<UserDto> users){
    String basePath = "/user/get/all";
    return   given(spec).basePath(basePath).log().all().when().get().then().log().all();
  }
}
