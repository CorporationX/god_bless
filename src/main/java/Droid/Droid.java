package Droid;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private String name;
    private final String ALL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encryptMessage(String message,
                                 int key,
                                 DroidMessageEncryptor<String, Integer> encryptor) {
        return encryptor.getMessage();
    }

    public String decryptMessage(String message,
                                 int key,
                                 DroidMessageEncryptor<String, Integer> encryptor) {
        return encryptor.getMessage();
    }

    public void sendMessage(Droid droid, String message, int key) {
        StringBuilder builder = new StringBuilder();

        String encMessage = encryptMessage(message, key, () -> {
            String upperCasedMessage = message.toUpperCase();
            for (int i = 0; i < upperCasedMessage.length(); i++) {
                char c = upperCasedMessage.charAt(i);
                if (Character.isLetter(c)) {
                    int currentIndex = ALL_LETTERS.indexOf(c);
                    int newIndex = (currentIndex + key) % ALL_LETTERS.length();
                    builder.append(ALL_LETTERS.charAt(newIndex));
                } else {
                    builder.append(c);
                }
            }
            return builder.toString();
        });
        System.out.println(getName() + " отправил зашифрованное сообщение: " + encMessage);
        droid.receiveMessage(builder.toString(), key);

    }

    private void receiveMessage(String message, int key) {
        StringBuilder builder = new StringBuilder();

        String decMessage = decryptMessage(message, key, () -> {
            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                if (Character.isLetter(c)) {
                    int currentIndex = ALL_LETTERS.indexOf(c);
                    int newIndex = (currentIndex - key) % ALL_LETTERS.length();
                    if (newIndex < 0) {
                        newIndex += ALL_LETTERS.length();
                    }
                    builder.append(ALL_LETTERS.charAt(newIndex));
                } else {
                    builder.append(c);
                }
            }
            return builder.toString();
        });
        System.out.println(this.getName() + " получил расшифрованное сообщение: " + decMessage);
    }
}
