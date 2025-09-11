package school.faang.functional_interfaces__lambdas.bjs2_87385;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (newMessage, encriptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder(message);
            // Импровизированный алгоритм шифрования, не стал с этим заморачиваться и переписывать из подсказки)
            for (int i = 0; i < message.length(); i++) {
                if ((encryptedMessage.charAt(i) == ' ')
                        || (encryptedMessage.charAt(i) == '.')
                        || (encryptedMessage.charAt(i) == ',')
                        || (encryptedMessage.charAt(i) == '?')
                        || (encryptedMessage.charAt(i) == '!')) {
                    continue;
                }
                encryptedMessage.setCharAt(i, (char) (encryptedMessage.charAt(i) + key));
            }
            return encryptedMessage.toString();
        };
        return encryptor.encript(message, key);
    }

    public void sendMessage(Droid droidRecipient, String message, int key) {
        String droidMessage = droidRecipient.encryptMessage(message, key);
        System.out.println("\n" + this.name + " направил шифрованное послание для "
                + droidRecipient.name + ": " + droidMessage);
        droidRecipient.receiveMessage(droidMessage, key);
    }

    public void receiveMessage(String message, int key) {
        System.out.println(this.name + " расшифровал сообщение: " + encryptMessage(message, (-1) * key));
    }
}
