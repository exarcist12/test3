package services;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseSpec {
	private  static String BASE_URL = System.getProperty("webdriver.base.url");

	private RequestSpecification spec = given().baseUri(BASE_URL).contentType(ContentType.JSON);

	public void setSpec(RequestSpecification spec) {
		this.spec = spec;
	}

	public RequestSpecification getSpec() {
		return spec;
	}

}
