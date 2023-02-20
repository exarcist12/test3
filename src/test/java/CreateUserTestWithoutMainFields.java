import dto.ResponseCode;
import dto.User;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserApi;

public class CreateUserTestWithoutMainFields {
	@Test
	void createUser(){
		UserApi userApi = new UserApi();
		User user = User.builder()
				.email("text@text.ru")
				.build();

		ValidatableResponse response = userApi.createUser(user);

		ResponseCode responseCode = response.extract().body().as(ResponseCode.class);

		Assertions.assertAll("Check response",
			() -> Assertions.assertEquals("null", responseCode.getMessage())
        );
	}


}
