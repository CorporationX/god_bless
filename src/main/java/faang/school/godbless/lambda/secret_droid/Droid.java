package faang.school.godbless.lambda.secret_droid;

public class Droid {
    public String sendEncryptedMessage(String message, int keyEncrypt) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            char[] chars = m.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                int start = Character.isUpperCase(ch) ? 'A' : 'a';
                char new_ch = (char) (((ch - start + k) % 26) + start);
                chars[i] = new_ch;
            }
            return new String(chars);
        };
        return encryptor.encrypt(message, keyEncrypt);
    }

    public String receiveEncryptedMessage(String message, int keyEncrypt) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            char[] chars = m.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                int start = Character.isUpperCase(ch) ? 'A' : 'a';
                char new_ch = (char) ((((ch - start - k) % 26 + 26) % 26) + start);
                chars[i] = new_ch;
            }
            return new String(chars);
        };
        return encryptor.encrypt(message, keyEncrypt);
    }
}
