package services.course;

import dto.course.CourseDto;
import dto.course.UserDto;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;


public class GetAllCoursesApi {
  private BaseCourseSpec baseCourseSpecSpec = new BaseCourseSpec();

  private RequestSpecification spec;

  public GetAllCoursesApi(){
    spec = baseCourseSpecSpec.getSpec();
  }

  public ValidatableResponse getCourses(List<CourseDto> courses){
    String basePath = "/cource/get/all";
    return   given(spec).basePath(basePath).log().all().when().get().then().log().all();
  }
}
