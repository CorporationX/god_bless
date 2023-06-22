package faang.school.godbless.kxnvg.starwars;

public class DroidMessageReceiver {

    public static void receiveEncryptedMessage(String encryptedMessage, int key) {
        if (key <= 0) {
            throw new IllegalArgumentException("Ключ шифрование должен быть больше 0");
        }

        DroidMessageEncryptor messageEncryptor = (tempMessage, tempKey) -> {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < encryptedMessage.length(); i++) {
                char ch = encryptedMessage.charAt(i);
                if (Character.isLetter(ch) || Character.isDigit(ch)) {
                    char tempChar = (char) (ch - tempKey);
                    builder.append(tempChar);
                } else {
                    builder.append(ch);
                }
            }
            return builder.toString();
        };
        System.out.println(messageEncryptor.encryption(encryptedMessage, key));
    }
}
