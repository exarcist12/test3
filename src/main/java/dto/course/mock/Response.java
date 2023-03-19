
package dto.course.mock;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {

  @SerializedName("body")
  private String body;

  @SerializedName("headers")
  private Headers headers;

  @SerializedName("status")
  private Integer status;

}
