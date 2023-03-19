package services.course;
import static io.restassured.RestAssured.given;

import dto.course.mock.*;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.google.gson.Gson;

public class GetMocksApi {
  private BaseCourseSpec baseCourseSpecSpec = new BaseCourseSpec();
  private RequestSpecification spec;
  public GetMocksApi(){
    spec = baseCourseSpecSpec.getSpec();
  }

  public Mappings getMappings(){

    String basePath = "/__admin/mappings";
    Gson gson = new Gson();
    ValidatableResponse validatableResponse = given(spec).basePath(basePath).log().all().when().get().then().log().all();
    String json2 = validatableResponse.extract().body().asString();
    Mappings mappings =  gson.fromJson(json2, Mappings.class);
    return mappings;
  }


}
