package faang.school.godbless.DroidSecrets;

import lombok.Data;

@Data
public class Droid {
    private String message;

    public void sendEncryptedMessage(Droid droid, String message, Integer encryptionKey) {
        DroidMessageEncryption droidMessageEncryption = (m, k) -> {
            StringBuilder stringBuilder = new StringBuilder(m);
            for (int i = 0; i < stringBuilder.length(); i++) {
                stringBuilder.replace(i, i + 1, String.valueOf(Character.toChars(stringBuilder.charAt(i) + k)[0]));
            }
            return stringBuilder.toString();
        };
        droid.setMessage(droidMessageEncryption.encrypt(message, encryptionKey));
    }


}
