package school.faang.bjs2_87401;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@AllArgsConstructor
@ToString
public class Droid {
    private final String name;

    public void sendMessage(Droid droid, String mes, int key) {
        String newMes = encryptMessage(mes, key);
        System.out.printf("droid %s - Sent an encrypted message: %s\n", name, newMes);
        droid.receiveMessage(newMes, key);
    }

    public void receiveMessage(String mes, int key) {
        String newMes = decryptMessage(mes, key);
        System.out.printf("droid %s - decrypted the message: %s\n", name, newMes);
    }

    private String encryptMessage(String mes, int key) {
        return DroidService.droidMessageEncryptor.convertMessage(mes, key);
    }

    private String decryptMessage(String mes, int key) {
        key = key * (-1);
        return DroidService.droidMessageEncryptor.convertMessage(mes,  key);
    }

}
