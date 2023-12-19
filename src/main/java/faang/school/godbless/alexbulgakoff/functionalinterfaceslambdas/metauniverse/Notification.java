package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.metauniverse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Notification {
    private String type;
    @Setter
    private String message;
}
