package services.course;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;


public class GetAllCoursesApi {
  private BaseCourseSpec baseCourseSpecSpec = new BaseCourseSpec();

  private RequestSpecification spec;
  private ResponseSpecification resSpec;

  public GetAllCoursesApi(){
    spec = baseCourseSpecSpec.getSpec();
  }

  public ValidatableResponse getCourses() {
    String basePath = "/cource/get/all";
    return   given(spec).contentType(ContentType.JSON).basePath(basePath).log().all().when().get().then().log().all();
  }
}
