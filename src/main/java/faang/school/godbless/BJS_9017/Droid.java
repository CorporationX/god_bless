package faang.school.godbless.BJS_9017;

import lombok.Getter;
import lombok.Setter;

import java.util.stream.Collectors;

@Getter
@Setter
public class Droid {
    private String message;
    private int key;
    private DroidMessageEncryptor messageEncryptor;

    public void sendEncryptedMessage(Droid droid, String message, int key) {
        messageEncryptor = (msg, k) -> msg.chars().mapToObj(ch -> {
            ch += k;
            return String.valueOf((char) ch);
        }).collect(Collectors.joining());

        droid.setMessage(messageEncryptor.implement(message, key));
        droid.setKey(key);
    }

    public void receiveEncryptedMessage() {
        System.out.println(this.getMessage());
        messageEncryptor = (msg, k) -> msg.chars().mapToObj(ch -> {
            ch -= k;
            return String.valueOf((char) ch);
        }).collect(Collectors.joining());
        System.out.println(messageEncryptor.implement(this.message, this.key));
    }
}
