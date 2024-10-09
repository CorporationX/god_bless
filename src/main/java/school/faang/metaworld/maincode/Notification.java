package school.faang.metaworld.maincode;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Notification {
    private String type;
    private String message;
}
