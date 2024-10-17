package module_2.module_2_1_Lambda.metaCosmos;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Notification {
    private final String type;
    private final String message;

}
