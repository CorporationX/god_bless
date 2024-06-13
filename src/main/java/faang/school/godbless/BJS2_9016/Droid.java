package faang.school.godbless.BJS2_9016;


import java.util.function.BiFunction;

public class Droid {
    private final String LOWER_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final DroidMessageEncryptor CRYPT_PROCESSING = (m, k, cryptOperation) -> {
        String encryptedMessage = "";

        for (int i = 0; i < m.length(); i++) {
            String letter = String.valueOf(m.charAt(i));
            String cryptLetter = letter.toLowerCase();

            // шифровка
            cryptLetter = cryptOperation.apply(cryptLetter, k);

            // если изначально символ капитальный, то делаем криптованый капитальным
            if (letter.equals(letter.toUpperCase())) {
                cryptLetter = cryptLetter.toUpperCase();
            }

            encryptedMessage += cryptLetter;
        }

        return encryptedMessage;
    };

    private final BiFunction<String, Integer, String> DECRYPT = (cryptLetter, k) ->
            "" + LOWER_ALPHABET.charAt((LOWER_ALPHABET.indexOf(cryptLetter) - k) % 26);
    private final BiFunction<String, Integer, String> CRYPT = (cryptLetter, k) ->
            "" + LOWER_ALPHABET.charAt((LOWER_ALPHABET.indexOf(cryptLetter) + k) % 26);

    public String sendEncryptedMessage(String message, int key) {
        return CRYPT_PROCESSING.crypt(message, key, CRYPT);
    }

    public String receiveEncryptedMessage(String message, int key) {
        return CRYPT_PROCESSING.crypt(message, key, DECRYPT);
    }


}
