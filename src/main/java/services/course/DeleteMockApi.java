package services.course;

import dto.course.mock.Mapping;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class DeleteMockApi {
  private BaseCourseSpec baseCourseSpecSpec = new BaseCourseSpec();

  private RequestSpecification spec;

  public DeleteMockApi(){
    spec = baseCourseSpecSpec.getSpec();
  }

  public void deleteMock(Mapping mapping){

    String basePath = "/__admin/mappings/"+ mapping.getId();

    given(spec).basePath(basePath).log().all().when().delete().then().log().all();

  }
}
