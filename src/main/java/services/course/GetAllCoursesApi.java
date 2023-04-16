package services.course;
import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.http.ContentType;

public class GetAllCoursesApi {
  private BaseCourseSpec baseCourseSpecSpec = new BaseCourseSpec();

  private RequestSpecification spec;
  private ResponseSpecification resSpec;

  public GetAllCoursesApi(){
    spec = baseCourseSpecSpec.getSpec();
  }

  @Step("Получаем все курсы")
  public ValidatableResponse getCourses() {
    String basePath = "/cource/get/all";
    return   given(spec).contentType(ContentType.JSON).basePath(basePath).log().all().when().get().then().log().all();
  }
}
