import com.github.javafaker.Faker;
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

public class CreateAndGetUserTest {

  private Faker faker = new Faker();
  private UserApi userApi = new UserApi();

  private GetUserApi getUserApi = new GetUserApi();
  private DeleteUserApi deleteUserApi = new DeleteUserApi();

  private User user = User.builder()
          .email(faker.animal().name() + faker.cat().name())
          .firstName(faker.animal().name() + faker.cat().name())
          .id(String.valueOf(new Random().nextInt(1000000)))
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
  void createUserTest(){
    ValidatableResponse response = getUserApi.getUser(user);
    User newUser = response.extract().body().as(User.class);
    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals(user.getUserStatus(), newUser.getUserStatus()),
        () -> Assertions.assertEquals(user.getPhone(), newUser.getPhone()),
        () -> Assertions.assertEquals(user.getEmail(), newUser.getEmail()));
  }
}
