package school.faang.sprint_2.droids_secrets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Getter
@Slf4j
public class Droid   {
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    DroidMessageEncryptor encryptor = (message, k) -> message.chars()
            .mapToObj(c -> {
                char ch = (char) c;
                if (Character.isUpperCase(ch)) {
                    return String.valueOf((char) (((ch - 'A' + k) % 26 + 26) % 26 + 'A'));
                } else if (Character.isLowerCase(ch)) {
                    return String.valueOf((char) (((ch - 'a' + k) % 26 + 26) % 26 + 'a'));
                } else {
                    return String.valueOf(ch); // не шифруем знаки и пробелы
                }
            })
            .collect(Collectors.joining());

    public String encryptMessage(String message, int key) {
        return encryptor.encrypt(message, key);
    }

    public  String decryptMessage(String message, int key) {
        return encryptor.encrypt(message, -key);
    }

    public void sendMessageTo(Droid droid, String message, int key) {
        String encrypted = encryptMessage(message, key);
        log.info("Droid {} sended a message {} to {}",
                this.name, encryptMessage(message, key), droid.getName());
        droid.receiveMessageFrom(this, encrypted, key);
    }

    public void receiveMessageFrom(Droid droid, String message, int key) {
        log.info("Droid {} receive message {} from {}",
                this.name, decryptMessage(message, key), droid.getName());
    }
}
