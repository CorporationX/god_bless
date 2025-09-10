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

    private String encryptMessage(String mes, int key) {
        return droidMessageEncryptor.convertMessage(mes, key);
    }

    public void sendMessage(Droid droid, String mes, int key) {
        String newMes = encryptMessage(mes, key);
        System.out.printf("droid %s - Sent an encrypted message: %s\n", name, newMes);
        droid.receiveMessage(newMes, key);
    }

    private String decryptMessage(String mes, int key) {

        return droidMessageEncryptor.convertMessage(mes, 26 - key);
    }

    public void receiveMessage(String mes, int key) {
        String newMes = decryptMessage(mes, key);
        System.out.printf("droid %s - decrypted the message: %s\n", name, newMes);
    }

    private final DroidMessageEncryptor droidMessageEncryptor = (String mes, int key) -> {
        if (Objects.isNull(mes) || mes.isBlank()) {
            throw new RuntimeException("Message text missing!!");
        }

        StringBuilder stringBuilder = new StringBuilder(mes.length());
        String tmpMes = "";

        while (key > 26) {
            key -= 26;
        }
        for (int i = 0; i < mes.length(); i++) {
            char c = mes.charAt(i);
            if (c >= 65 && c <= 90) {
                tmpMes = stringBuilder.append(codeChar(c, key, 65)).toString();
            } else {
                if (c >= 97 && c <= 122) {
                    tmpMes = stringBuilder.append(codeChar(c, key, 97)).toString();
                } else {
                    tmpMes = String.valueOf(stringBuilder.append(c));
                }
            }
        }
        return tmpMes;
    };


    private char codeChar(char c, int key, int shift) {
        int a = (int) c + key;
        if (a >= shift + 26) {
            a -= 26;
        }
        return (char) a;
    }

}
