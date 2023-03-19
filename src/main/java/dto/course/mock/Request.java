
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
public class Request {

    @SerializedName("method")
    private String method;

    @SerializedName("url")
    private String url;

    @SerializedName("urlPathPattern")
    private String urlPathPattern;


}
