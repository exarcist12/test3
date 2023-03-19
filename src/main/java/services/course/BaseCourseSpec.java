package services.course;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
public class BaseCourseSpec {
  private  static String BASE_URL = System.getProperty("webdriver.base.url");
  private RequestSpecification spec = given().baseUri(BASE_URL).contentType(ContentType.JSON);

  public RequestSpecification getSpec() {
    return spec;
  }

}
