import dto.ResponseCode;
import dto.User;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DeleteUserApi;
import services.UserApi;

public class CreateUserWithoutUsernameNegativeTest {

  private UserApi userApi = new UserApi();
  private DeleteUserApi deleteUserApi = new DeleteUserApi();

  private User user = User.builder()
          .email("text@text.ru")
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
  void testCreateNegativeWithoutUsername(){
    ValidatableResponse response = userApi.createUser(user);

    ResponseCode responseCode = response.extract().body().as(ResponseCode.class);

    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals("null", responseCode.getMessage())
    );
  }
}
