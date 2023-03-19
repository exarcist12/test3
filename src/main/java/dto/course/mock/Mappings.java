
package dto.course.mock;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mappings {

    @SerializedName("mappings")
    private List<Mapping> mappings;
    @SerializedName("meta")
    private Meta meta;

}
