import dto.User;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import services.UserApi;

public class CreateUserTest {
	@Test
	void createUser(){
		UserApi userApi = new UserApi();
		User user = User.builder()
				.email("Email2")
				.firstName("FirstNameewrwe")
				.id(123123)
				.userStatus(123123)
				.lastName("lawerwerstName")
				.password("247wer3845")
				.phone("werwer")
				.username("werwerwer")
				.build();

		ValidatableResponse response = userApi.createUser(user);
	}

}
