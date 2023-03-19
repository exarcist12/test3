package helpers;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import dto.course.CourseDto;
import dto.course.mock.Mapping;
import dto.course.mock.Mappings;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.course.*;

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

  @BeforeEach
  void createMock(){
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
