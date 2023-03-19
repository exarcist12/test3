package services.course;

import com.google.gson.Gson;
import dto.course.UserDto;
import dto.course.mock.Headers;
import dto.course.mock.Mock;
import dto.course.mock.Request;
import dto.course.mock.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class CreateMockApi {
  private BaseCourseSpec baseCourseSpecSpec = new BaseCourseSpec();
  private RequestSpecification spec;
  public CreateMockApi(){
    spec = baseCourseSpecSpec.getSpec();
  }

  public Mock createMockCourses(){
    String body = "[{\"name\":\"QA java\",\"price\": 15000},{\"name\":\"Java\",\"price\": 12000}]";

    String basePath = "/__admin/mappings";

    Mock mock = Mock.builder().name("Получение курсов")
            .request(Request.builder()
                    .method("GET")
                    .url("/cource/get/all").build())
            .response(Response.builder()
                    .status(200)
                    .body(body)
                    .headers(Headers.builder()
                            .contentType("application/json").build())
                    .build())
            .build();
    Gson gson = new Gson();
    String json = gson.toJson(mock);
    ValidatableResponse validatableResponse = given(spec).basePath(basePath).body(json).log().all().when().post().then().log().all();
    String json2 = validatableResponse.extract().body().asString();
    Mock mock2 =  gson.fromJson(json2, Mock.class);
    return  mock2;
  }

  public Mock createMockUsers(){
    String body = "{\"name\":\"Test user\",\"cource\":\"QA\",\"email\":\"test@test.test\",\"age\": 23}";

    String basePath = "/__admin/mappings";

    Mock mock = Mock.builder().name("Получение пользователей")
            .request(Request.builder()
                    .method("GET")
                    .url("/user/get/all").build())
            .response(Response.builder()
                    .status(200)
                    .body(body)
                    .headers(Headers.builder()
                            .contentType("application/json").build())
                    .build())
            .build();
    Gson gson = new Gson();
    String json = gson.toJson(mock);
    ValidatableResponse validatableResponse = given(spec).basePath(basePath).body(json).log().all().when().post().then().log().all();
    String json2 = validatableResponse.extract().body().asString();
    Mock mock2 =  gson.fromJson(json2, Mock.class);
    return  mock2;
  }


  public Mock createMockGetScore(UserDto user){
    String body = "{\"name\":\"" + user.getName() + "\",\"score\": 78}";

    String basePath = "/__admin/mappings";

    Mock mock = Mock.builder().name("Получение оценки пользователя")
            .request(Request.builder()
                    .method("GET")
                    .url("/user/get/"+user.getName()).build())
            .response(Response.builder()
                    .status(200)
                    .body(body)
                    .headers(Headers.builder()
                            .contentType("application/json").build())
                    .build())
            .build();
    Gson gson = new Gson();
    String json = gson.toJson(mock);
    ValidatableResponse validatableResponse = given(spec).basePath(basePath).body(json).log().all().when().post().then().log().all();
    String json2 = validatableResponse.extract().body().asString();
    Mock mock2 =  gson.fromJson(json2, Mock.class);
    return  mock2;
  }
}
