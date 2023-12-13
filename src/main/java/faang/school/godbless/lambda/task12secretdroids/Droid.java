package faang.school.godbless.lambda.task12secretdroids;

import lombok.Data;

@Data
public class Droid {
    public String sendEncryptedMessage(String message, int keyEnc) {
        DroidMessageEncryptor encryptor = (mes, key) -> {
            char[] noEncrypted = mes.toCharArray();
            char[] encrypted = new char[mes.length()];
            for (int i = 0; i < mes.length(); i++) {
                encrypted[i] = (char) (noEncrypted[i] + key);
            }
            return String.valueOf(encrypted);
        };

        return encryptor.encrypt(message, keyEnc);
    }

    public void receiveEncryptedMessage(String message, int keyEnc) {
        DroidMessageEncryptor encryptor = (mes, key) -> {
            char[] encrypted = mes.toCharArray();
            char[] noEncrypted = new char[mes.length()];
            for (int i = 0; i < mes.length(); i++) {
                noEncrypted[i] = (char) (encrypted[i] - key);
            }
            return String.valueOf(noEncrypted);
        };

        System.out.println(encryptor.encrypt(message, keyEnc));
    }

}
