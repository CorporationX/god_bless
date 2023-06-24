package faang.school.godbless.Droid.Secrets;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("БипБииииБип>", 2);
        Droid c3po = new Droid("Ну и дырень у Звезды смерти? Да R2D2?", 1);

        DroidMessageEncryptor encryptor = (message, key) -> {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = message.toCharArray();
            for (char ch : chars) {
                ch += key;
                stringBuilder.append(ch);
            }

            return stringBuilder.toString();
        };

        String encryptedMessage = c3po.sendEncryptedMessage(encryptor);
        System.out.println(encryptedMessage);

        r2d2.receiveEncryptedMessage(encryptedMessage, c3po.getKey(), encryptor);
    }
}
