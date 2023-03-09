import dto.ResponseCode;
import dto.User;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserApi;

import java.util.Random;

public class CreateUserTest {
  @Test
  void createUser(){
    UserApi userApi = new UserApi();
    User user = User.builder()
        .email("Email" + new Random().nextInt(1000000))
        .firstName("firstName"+ new Random().nextInt(1000000))
        .id(new Random().nextInt(1000000))
        .userStatus(new Random().nextInt(1000000))
        .lastName("lastName" + new Random().nextInt(1000000))
        .password("password" + new Random().nextInt(1000000))
        .phone("phone: " + new Random().nextInt(1000000000))
        .username("username" +  new Random().nextInt(1000000000))
        .build();

    ValidatableResponse response = userApi.createUser(user);

    ResponseCode userOut = response.extract().body().as(ResponseCode.class);

    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals(200, userOut.getCode()),
        () -> Assertions.assertEquals("unknown", userOut.getType()),
        () -> Assertions.assertEquals(user.getId().toString(), userOut.getMessage())
    );
  }


  @Test
  void createUser22() {
    String BASE_URL = System.getProperty("webdriver.base.url");
  }
}
