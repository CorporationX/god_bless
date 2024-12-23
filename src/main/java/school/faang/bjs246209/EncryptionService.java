package school.faang.bjs246209;

import java.util.function.Function;
import java.util.stream.Collectors;

public class EncryptionService {
    public void sendMessage(Droid sender, Droid droid, String message, int delta) {
        DroidMessageEncryptor encryptor = (msg) -> {
            System.out.printf("Message: '%s' was encrypted with algo no: %s\n", message, delta);
            return cryptWithAlgo(msg, c -> c - delta);
        };

        String encryptedMessage = encryptor.apply(message);
        System.out.println(sender + " is sending message to "  + droid.name());
        receiveMessage(sender, droid, encryptedMessage, delta);
    }

    public void receiveMessage(Droid sender, Droid droid, String message, int delta) {
        DroidMessageDecryptor decryptor = (msg) -> {
            System.out.printf("Message: '%s' was decrypted with algo no: %s\n", message, delta);
            return cryptWithAlgo(msg, c -> c + delta);
        };

        String decryptedMessage = decryptor.apply(message);
        System.out.println(droid + " have received message '" + decryptedMessage + "' from "  + sender.name());
    }

    private String cryptWithAlgo(String message, Function<Integer, Integer> deltaFunction) {
        return message.chars()
                .map(deltaFunction::apply)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        //        StringBuilder sb = new StringBuilder();
        //        message.chars().forEach(c -> sb.append((char) deltaFunction.apply(c).intValue()));
        //        return sb.toString();
    }
}
