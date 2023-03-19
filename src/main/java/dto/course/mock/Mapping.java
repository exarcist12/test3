
package dto.course.mock;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mapping {

  @SerializedName("name")
  private String name;

  @SerializedName("request")
  private Request request;

  @SerializedName("response")
  private Response response;

  @SerializedName("id")
  private UUID id;

  @SerializedName("uuid")
  private UUID uuid;


}
