package faang.school.godbless.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {

/*    private String message;
    private int keyCrypt;*/

    public String sendEncryptedMessage(String message, int keyCrypt) {
        return message + keyCrypt;
    }


}
