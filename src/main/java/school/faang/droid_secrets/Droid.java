package school.faang.droid_secrets;

import lombok.NonNull;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Character.isLetter;

public record Droid(@NonNull String name) {

    private String encryptMessage(@NonNull String message, int key) {

        DroidMessageEncryptor encryptor = (m, k) -> getShiftedString(m, key, true);

        return encryptor.encrypt(message, key);
    }

    private String getShiftedString(String message, int key, boolean typeEncoder) {
        char[] charArray = message.toCharArray();
        List<Character> charList = IntStream.range(0, charArray.length)
                .mapToObj(i -> charArray[i])
                .map(ch -> getShiftedCharacter(ch, key, typeEncoder))
                .toList();

        return charList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private Character getShiftedCharacter(Character inputCharacter, int key, boolean typeEncoder) {
        key = typeEncoder ? key : -key;

        if (isLetter(inputCharacter) && isLatinLetter(inputCharacter)) {
            char base = Character.isLowerCase(inputCharacter) ? 'a' : 'A';
            return (char) ((inputCharacter - base + key + 26) % 26 + base);
        }
        return inputCharacter;
    }

    public boolean isLatinLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private String decryptMessage(@NonNull String message, int key) {

        DroidMessageEncryptor decryptor = (m, k) -> getShiftedString(m, key, false);

        return decryptor.encrypt(message, key);
    }

    public void sendMessage(@NonNull Droid droid, @NonNull String message, int key) {

        String encryptedMessage = encryptMessage(message, key);

        System.out.println(MessageFormat.format("Droid {0} send encrypted message to droid {1}: {2}",
                this.name, droid.name, encryptedMessage));

        receiveMessage(droid, encryptedMessage, key);
    }

    public void receiveMessage(@NonNull Droid droid, @NonNull String message, int key) {

        String decryptedMessage = decryptMessage(message, key);

        System.out.println(MessageFormat.format("Droid {0} received decrypted message from droid {1}: {2}",
                droid.name, this.name, decryptedMessage));
    }

    public static void main(String[] args) {

        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(c3po, message1, encryptionKey1);
        c3po.sendMessage(r2d2, message2, encryptionKey2);
        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);
    }
}
