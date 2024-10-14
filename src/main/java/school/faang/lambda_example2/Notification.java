package school.faang.lambda_example2;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Notification {
    private String type;
    private String message;

}
