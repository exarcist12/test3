import com.github.javafaker.Faker;
import dto.ResponseCode;
import dto.User;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserApi;

import java.util.Random;

public class CreateUserLongIdNegativeTest {

  private Faker faker = new Faker();
  private UserApi userApi = new UserApi();

  private User user = User.builder()
          .email(faker.animal().name() + faker.cat().name())
          .firstName(faker.animal().name() + faker.cat().name())
          .id(RandomStringUtils.randomNumeric(60))
          .userStatus(new Random().nextInt(1000000))
          .lastName(faker.animal().name() + faker.cat().name())
          .password(faker.animal().name() + faker.cat().name())
          .phone(faker.animal().name() + faker.cat().name())
          .username(faker.animal().name() + faker.cat().name())
          .build();


  @Test
  void createUserTest(){
    userApi.createUser(user);
    ValidatableResponse response = userApi.createUser(user);
    ResponseCode code = response.extract().body().as(ResponseCode.class);
    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals(code.getCode(), "500"),
        () -> Assertions.assertEquals(code.getMessage(), "something bad happened"));
  }
}
