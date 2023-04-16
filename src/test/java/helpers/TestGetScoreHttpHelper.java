package helpers;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import dto.course.ScoreDto;
import dto.course.UserDto;
import dto.course.annotation.Driver;
import dto.course.mock.Mapping;
import dto.course.mock.Mappings;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import services.course.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class TestGetScoreHttpHelper {
  private CreateMockApi createMockApi = new CreateMockApi();
  private DeleteMockApi deleteMockApi = new DeleteMockApi();
  private GetAllCoursesApi getAllCoursesApi = new GetAllCoursesApi();
  private GetAllUsersApi getAllUsersApi = new GetAllUsersApi();

  private GetUserScoreApi getUserScoreApi = new GetUserScoreApi();
  private GetMocksApi getMocksApi = new GetMocksApi();

  private UserDto userDto = UserDto.builder().name("test").build();
  private ScoreDto scoreDto = ScoreDto.builder().score(78).name(userDto.getName()).build();

  @Driver
  private WebDriver driver;
  @BeforeEach
  void setupTest() throws MalformedURLException {
    createMockApi.createMockGetScore(userDto);
  }

  @AfterEach
  void deleteMock(){
    Mappings mappings = getMocksApi.getMappings();
    Mapping mapping = mappings.getMappings().stream().filter(p1 -> p1.getName().equals("Получение оценки пользователя")).findFirst().get();
    deleteMockApi.deleteMock(mapping);
  }

  @DisplayName("Проверка получения оценки пользователя")
  @Test
  void createScoreTest(){
    ValidatableResponse response = getUserScoreApi.getUserScore(userDto);
    ScoreDto scoreDto2 = response.extract().body().as(ScoreDto.class);
    assertThat("Проверка совпадения оценки", scoreDto2, equalTo(scoreDto));
  }
}
