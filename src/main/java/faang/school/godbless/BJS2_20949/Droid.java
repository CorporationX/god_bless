package faang.school.godbless.BJS2_20949;

import java.util.function.BiFunction;

public class Droid {

    public String changeMessage(String message, int key, BiFunction<Character, Integer, Character> coder){
        if(message == null || key == 0)
            throw new IllegalArgumentException("Incorrect data");

        DroidMessageEncryptor encryptor = (mess, k) -> {
            StringBuffer result = new StringBuffer();
            for (char symbol: mess.toCharArray()){
                result.append(coder.apply(symbol, k));
            }
            return result.toString();
        };

        return encryptor.encrypeMessage(message, key);
    }

    public String sendEncryptedMessage(String message, int key){
        BiFunction<Character, Integer, Character> encoder = (ch, step) -> (char) (ch + step);

        return changeMessage(message, key, encoder);
    }

    public String receiveEncryptedMessage(String message, int key){
        BiFunction<Character, Integer, Character> decoder = (ch, step) -> (char) (ch - step);

        return changeMessage(message, key, decoder);
    }
}
