package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	private String email;
	private String firstName;
	private Integer id;
	private String lastName;
	private String password;
	private String phone;
	private Integer userStatus;
	private String username;
}
