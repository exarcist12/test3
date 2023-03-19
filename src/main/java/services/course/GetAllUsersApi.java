package services.course;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import io.restassured.response.ValidatableResponse;

public class GetAllUsersApi {
  private BaseCourseSpec baseCourseSpecSpec = new BaseCourseSpec();

  private RequestSpecification spec;

  public GetAllUsersApi(){
    spec = baseCourseSpecSpec.getSpec();
  }

  public ValidatableResponse getUsers(){
    String basePath = "/user/get/all";
    return   given(spec).basePath(basePath).log().all().when().get().then().log().all();
  }
}
