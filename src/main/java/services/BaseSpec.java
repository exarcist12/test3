package services;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseSpec {
  private  static String BASE_URL = System.getProperty("webdriver.base.url");
  private RequestSpecification spec = given().baseUri(BASE_URL).contentType(ContentType.JSON);

  public RequestSpecification getSpec() {
    return spec;
  }

}
