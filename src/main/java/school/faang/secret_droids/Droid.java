package school.faang.secret_droids;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Droid {
    private final String name;
    private DroidMessageEncryptor droidMessageEncryptor;

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String message, Integer key) {
        droidMessageEncryptor = (msg, k) -> {
            StringBuilder strBox = new StringBuilder(message.length());
            char tmp;
            for (int i = 0; i < message.length(); i++) {
                tmp = message.charAt(i);
                if (Character.isLetter(message.charAt(i))) {
                    tmp += key % 26;
                    if (tmp > 'z') {
                        tmp = (char) (tmp % 'z' + 'a');
                    } else {
                        if (tmp < 'a') {
                            tmp = (char) (tmp + 25);
                        }
                    }
                }
                strBox.append(tmp);
            }
            return strBox.toString();
        };
        return droidMessageEncryptor.messageEncryptor(message, key);
    }

    public String decryptMessage(String message, Integer key) {
        droidMessageEncryptor = (msg, k) -> {
            StringBuilder strBox = new StringBuilder(msg.length());
            char tmp;
            for (int i = 0; i < msg.length(); i++) {
                tmp = msg.charAt(i);
                if (Character.isLetter(msg.charAt(i))) {
                    tmp += k % 26;
                    if (tmp > 'z') {
                        tmp = (char) (tmp % 'z' + 'a');
                    } else {
                        if (tmp < 'a') {
                            tmp = (char) (tmp + 25);
                        }
                    }
                }
                strBox.append(tmp);
            }
            return strBox.toString();
        };
        return droidMessageEncryptor.messageEncryptor(message, -key);
    }

    public void sendMessage(String message, int key, Droid droid) {
        droid.receiveMessage(encryptMessage(message, key), key);
    }

    public void receiveMessage(String message, int key) {
        System.out.println(this.decryptMessage(message, key));

    }
}
