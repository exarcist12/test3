import dto.course.CourseDto;
import dto.course.ScoreDto;
import dto.course.UserDto;
import dto.course.mock.Mock;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import services.course.*;

public class TestMock {
  private CreateMockApi createMockApi = new CreateMockApi();
  private DeleteMockApi deleteMockApi = new DeleteMockApi();
  private GetAllCoursesApi getAllCoursesApi = new GetAllCoursesApi();
  private GetAllUsersApi getAllUsersApi = new GetAllUsersApi();

  private GetUserScoreApi getUserScoreApi = new GetUserScoreApi();

  @Test
  void createCourseTest(){
    Mock mock = createMockApi.createMockCourses();
    ValidatableResponse response = getAllCoursesApi.getCourses();
    CourseDto[] courses = response.extract().body().as(CourseDto[].class);
    deleteMockApi.deleteMock(mock);
  }

  @Test
  void createUsersTest(){
    Mock mock = createMockApi.createMockUsers();
    ValidatableResponse response = getAllUsersApi.getUsers();
    UserDto users = response.extract().body().as(UserDto.class);
    deleteMockApi.deleteMock(mock);
  }


  @Test
  void createScoreTest(){
    Mock mock = createMockApi.createMockGetScore(UserDto.builder().name("textext").build());
    ValidatableResponse response = getUserScoreApi.getUserScore(UserDto.builder().name("textext").build());
    ScoreDto scoreDto = response.extract().body().as(ScoreDto.class);
    deleteMockApi.deleteMock(mock);
  }
}
