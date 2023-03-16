package services.course;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseCourseSpec {
  private  static String BASE_URL = System.getProperty("webdriver.basecourse.url");
  private RequestSpecification spec = given().baseUri(BASE_URL).contentType(ContentType.JSON);

  public RequestSpecification getSpec() {
    return spec;
  }

}
