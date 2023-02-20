package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseCode {
	private Long code;
	private String message;
	private String type;
}
