package helpers;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import dto.course.CourseDto;
import dto.course.annotation.Driver;
import dto.course.mock.Mapping;
import dto.course.mock.Mappings;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import services.course.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class TestGetCoursesHttpHelper {
  private Mapping mapping = new Mapping();
  private CreateMockApi createMockApi = new CreateMockApi();
  private DeleteMockApi deleteMockApi = new DeleteMockApi();
  private GetAllCoursesApi getAllCoursesApi = new GetAllCoursesApi();
  private GetMocksApi getMocksApi = new GetMocksApi();


  CourseDto courseDto = CourseDto.builder()
          .name("QA java")
          .price(15000)
          .build();
  CourseDto courseDto2 = CourseDto.builder()
          .name("Java")
          .price(12000)
          .build();

  CourseDto[] courses = {courseDto, courseDto2};

  @Driver
  private WebDriver driver;
  @BeforeEach
  void setupTest() throws MalformedURLException {
    Map<String, Object> selenoidOptions = new HashMap<>();
    selenoidOptions.put("enableVNC", true);
    selenoidOptions.put("enableVideo", true);
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", "chrome");
    capabilities.setCapability("browserVersion", "109.0");
    capabilities.setCapability("selenoid:options", selenoidOptions);
    driver = new RemoteWebDriver(
            URI.create("http://127.0.0.1:8080/wd/hub").toURL(),
            capabilities
    );
    createMockApi.createMockCourses();
  }

  @AfterEach
  void deleteMock(){
    Mappings mappings = getMocksApi.getMappings();
    Mapping mapping = mappings.getMappings().stream().filter(p1 -> p1.getName().equals("Получение курсов")).findFirst().get();
    deleteMockApi.deleteMock(mapping);
  }

  @Test
  void createCourseTest(){
    ValidatableResponse response = getAllCoursesApi.getCourses();
    CourseDto[] courses2 = response.extract().body().as(CourseDto[].class);
    assertThat("Проверка совпадения объектов", courses, equalTo(courses2));
  }
}
