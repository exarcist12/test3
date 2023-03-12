package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String email;
  private String firstName;
  private String id;
  private String lastName;
  private String password;
  private String phone;
  private Integer userStatus;
  private String username;
}
