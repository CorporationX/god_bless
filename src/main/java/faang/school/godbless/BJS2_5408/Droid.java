package faang.school.godbless.BJS2_5408;

import java.util.List;
import java.util.stream.Collectors;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            List<Character> chars = msg.chars().mapToObj(c -> (char) c).toList();

            return chars.stream().mapToInt(str -> {
                int position = (int) str;

                if (Character.isUpperCase(str)) {
                    position = 90 - ((int) str + key);
                    position = position >= 0 ? (int) str + key : 64 + Math.abs(position);
                } else if (Character.isLowerCase(str)) {
                    position = 122 - ((int) str + key);
                    position = position >= 0 ? (int) str + key : 96 + Math.abs(position);
                }
                return position;
            }).mapToObj(cod -> Character.toString((char) cod)).collect(Collectors.joining());
        };
        return encryptor.accept(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            List<Character> chars = msg.chars().mapToObj(c -> (char) c).toList();

            return chars.stream().mapToInt(str -> {
                int position = (int) str;


                if (Character.isUpperCase(str)) {
                    position = (int) str - key;
                    int shiftFromTop = 65 - ((int) str - key);
                    position = 65 <= position ? (int) str - key : 90 - Math.abs(shiftFromTop);
                } else if (Character.isLowerCase(str)) {
                    position = (int) str - key;
                    int shiftFromTop = 97 - ((int) str - key);
                    position = 97 <= position ? (int) str - key : 123 - Math.abs(shiftFromTop);
                }
                return position;
            }).mapToObj(cod -> Character.toString((char) cod)).collect(Collectors.joining());
        };
        return encryptor.accept(message, encryptionKey);
    }
}