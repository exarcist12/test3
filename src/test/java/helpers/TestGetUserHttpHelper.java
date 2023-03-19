package helpers;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import dto.course.annotation.Driver;
import dto.course.mock.Mapping;
import dto.course.mock.Mappings;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import services.course.*;
import dto.course.UserDto;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class TestGetUserHttpHelper {
  private CreateMockApi createMockApi = new CreateMockApi();
  private DeleteMockApi deleteMockApi = new DeleteMockApi();
  private GetAllUsersApi getAllUsersApi = new GetAllUsersApi();
  private GetMocksApi getMocksApi = new GetMocksApi();

  UserDto userDto = UserDto.builder()
          .name("Test user")
          .cource("QA")
          .email("test@test.test")
          .age(23)
          .build();

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
    createMockApi.createMockUsers();
  }


  @AfterEach
  void deleteMock(){
    Mappings mappings = getMocksApi.getMappings();
    Mapping mapping = mappings.getMappings().stream().filter(p1 -> p1.getName().equals("Получение пользователей")).findFirst().get();
    deleteMockApi.deleteMock(mapping);
  }

  @Test
  void createUsersTest(){
    ValidatableResponse response = getAllUsersApi.getUsers();
    UserDto user = response.extract().body().as(UserDto.class);
    assertThat("Проверка пользователя", user, equalTo(userDto));
  }

}
