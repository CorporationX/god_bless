package school.faang.secretsOfTheDroids80145;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InfoMessage {
    private int idMessage;
    private String message;
    private int key;
    private Droid sender;
    private Droid recipient;

}
