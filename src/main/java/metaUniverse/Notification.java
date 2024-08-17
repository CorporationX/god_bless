package metaUniverse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class Notification {
    private String type;
    private String message;


}
