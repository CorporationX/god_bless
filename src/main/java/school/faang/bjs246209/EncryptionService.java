package school.faang.bjs246209;

public class EncryptionService {
    private final DroidMessageDecrypt<String, Integer, String> decrypted = (msg, key) -> {
        System.out.printf("Message: '%s' decrypting with algo no: %s\n", msg, key);
        return cryptWithAlgo(msg, key, false);
    };

    public void sendMessage(Droid sender, Droid droid, String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            System.out.printf("Message: '%s' was encrypted with algo no: %s\n", msg, key);
            return cryptWithAlgo(msg, key, true);
        };

        String encryptedMessage = encryptor.apply(message, encryptionKey);
        System.out.println(sender + " is sending message to "  + droid.name());
        receiveMessage(sender, droid, encryptedMessage, encryptionKey);
    }

    public void receiveMessage(Droid sender, Droid droid, String message, int encryptionKey) {
        String decryptedMessage = decrypted.apply(message, encryptionKey);
        System.out.println(droid + " have received message '" + decryptedMessage + "' from "  + sender.name());
    }

    private String cryptWithAlgo(String message, int algo, boolean isEncrypt) {

        //        var result = message.chars()
        //                .map(c -> isEncrypt ? c - algo : c + algo)
        //                .mapToObj(c -> String.valueOf((char) c))
        //                .collect(Collectors.joining());

        StringBuilder sb = new StringBuilder();
        message.chars().forEach(c -> sb.append((char) (isEncrypt ? c - algo : c + algo)));
        String result = sb.toString();

        return result;
    }
}
