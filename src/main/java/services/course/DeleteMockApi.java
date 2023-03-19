package services.course;

import com.google.gson.Gson;
import dto.course.mock.Headers;
import dto.course.mock.Mock;
import dto.course.mock.Request;
import dto.course.mock.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class DeleteMockApi {
  private BaseCourseSpec baseCourseSpecSpec = new BaseCourseSpec();

  private RequestSpecification spec;

  public DeleteMockApi(){
    spec = baseCourseSpecSpec.getSpec();
  }

  public void deleteMock(Mock mock){

    String basePath = "/__admin/mappings/"+ mock.getId();

    ValidatableResponse validatableResponse = given(spec).basePath(basePath).log().all().when().delete().then().log().all();

  }
}
