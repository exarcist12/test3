import com.github.javafaker.Faker;
import dto.ResponseCode;
import dto.User;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DeleteUserApi;
import services.GetUserApi;
import services.UserApi;

import java.util.Random;

public class CreateUserTestNegativeLongId {

  Faker faker = new Faker();
  UserApi userApi = new UserApi();

  User user = User.builder()
          .email(faker.animal().name() + faker.cat().name())
          .firstName(faker.animal().name() + faker.cat().name())
          .id("123123223453454353453453534534534534534534534534534534534555454455443454534545453")
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
