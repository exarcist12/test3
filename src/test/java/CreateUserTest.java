import com.github.javafaker.Faker;
import dto.ResponseCode;
import dto.User;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DeleteUserApi;
import services.UserApi;

import java.util.Random;

public class CreateUserTest {

  Faker faker = new Faker();
  UserApi userApi = new UserApi();
  DeleteUserApi deleteUserApi = new DeleteUserApi();

  User user = User.builder()
          .email(faker.animal().name() + faker.cat().name())
          .firstName(faker.animal().name() + faker.cat().name())
          .id(new Random().nextInt(1000000))
          .userStatus(new Random().nextInt(1000000))
          .lastName(faker.animal().name() + faker.cat().name())
          .password(faker.animal().name() + faker.cat().name())
          .phone(faker.animal().name() + faker.cat().name())
          .username(faker.animal().name() + faker.cat().name())
          .build();
  @BeforeEach
  void createUser(){
    userApi.createUser(user);
  }

  @AfterEach
  void deletionUser(){
    deleteUserApi.deleteUser(user);
  }


  @Test
  void getuser(){
    User user3 = user;
  }

  @Test
  void createUse2r(){
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
    UserApi userApi = new UserApi();
    DeleteUserApi deleteUserApi = new DeleteUserApi();
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

    ValidatableResponse response2 = deleteUserApi.deleteUser(user);

    ResponseCode userOut2 = response2.extract().body().as(ResponseCode.class);

    Assertions.assertAll("Check response",
            () -> Assertions.assertEquals(200, userOut.getCode()),
            () -> Assertions.assertEquals("unknown", userOut.getType()),
            () -> Assertions.assertEquals(user.getId().toString(), userOut.getMessage())
    );
  }

  @Test
  void createUser32() {

    String text = faker.animal().name() + faker.cat().name();
  }

}
