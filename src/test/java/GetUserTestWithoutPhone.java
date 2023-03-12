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

public class GetUserTestWithoutPhone {

  Faker faker = new Faker();
  UserApi userApi = new UserApi();

  GetUserApi getUserApi = new GetUserApi();
  DeleteUserApi deleteUserApi = new DeleteUserApi();

  User user = User.builder()
          .email(faker.animal().name() + faker.cat().name())
          .firstName(faker.animal().name() + faker.cat().name())
          .id(String.valueOf(new Random().nextInt(1000000)))
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
  void getTestWithoutPhoneNegative(){
    ValidatableResponse response = getUserApi.getUser(user);

    User newUser = response.extract().body().as(User.class);

    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals(user.getPhone(), newUser.getPhone())
    );
  }
}
