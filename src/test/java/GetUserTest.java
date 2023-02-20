import dto.User;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.GetUserApi;
import services.UserApi;

import java.util.Random;

public class GetUserTest {
	@Test
	void createUser(){
		UserApi userApi = new UserApi();
		GetUserApi getUserApi = new GetUserApi();
		User user = User.builder()
				.email("Email" + new Random().nextInt(1000000))
				.firstName("firstName"+ new Random().nextInt(1000000))
				.id(new Random().nextInt(1000000))
				.userStatus(new Random().nextInt(1000000))
				.lastName("lastName" + new Random().nextInt(1000000))
				.password("password" + new Random().nextInt(1000000))
				.phone("phone: " + new Random().nextInt(1000000000))
				.username("username" +  + new Random().nextInt(1000000))
				.build();

		userApi.createUser(user);

		ValidatableResponse response = getUserApi.getUser(user);

		User newUser = response.extract().body().as(User.class);

		Assertions.assertAll("Check response",
				() -> Assertions.assertEquals( user.getUserStatus(), newUser.getUserStatus()),
				() -> Assertions.assertEquals(user.getPhone(), newUser.getPhone()),
				() -> Assertions.assertEquals(user.getEmail(), newUser.getEmail())
		);


	}


}
