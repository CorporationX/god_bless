package faang.school.godbless.BJS_9017;

import lombok.Getter;
import lombok.Setter;

import java.util.stream.Collectors;

@Getter
@Setter
public class Droid {
    private DroidMessageEncryptor messageEncryptor;

    public String sendEncryptedMessage(String message, int key) {
        messageEncryptor = (msg, k) -> msg.chars().mapToObj(ch -> {
            ch += k;
            return String.valueOf((char) ch);
        }).collect(Collectors.joining());
        return messageEncryptor.implement(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        messageEncryptor = (msg, k) -> msg.chars().mapToObj(ch -> {
            ch -= k;
            return String.valueOf((char) ch);
        }).collect(Collectors.joining());
        return messageEncryptor.implement(message, key);
    }
}
