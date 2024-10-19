package school.faang.droids;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String stringMessage, int key) {
        DroidMessageEncryptor encryptor = (message, encriptKey) -> message.chars()
                .mapToObj(symbol -> {
                    if (Character.isLetter(symbol)) {
                        char base = Character.isLowerCase(symbol) ? 'a' : 'A';
                        return (char) ((symbol - base + encriptKey) % 26 + base);
                    }
                    return (char) symbol;
                }).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        return encryptor.funcEncryption(stringMessage, key);
    }

    public String decryptMessage(String encryptMessage, int key) {
        DroidMessageEncryptor encryptor = (message, encriptKey) -> message.chars()
                .mapToObj(symbol -> {
                    if (Character.isLetter(symbol)) {
                        char base = Character.isLowerCase(symbol) ? 'a' : 'A';
                        return (char) ((symbol - base - encriptKey + 26) % 26 + base);
                    }
                    return (char) symbol;
                }).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        return encryptor.funcEncryption(encryptMessage, key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String messageToSend = encryptMessage(message, key);
        System.out.println(droid.name + " отправил зашифрованное сообщение: " + messageToSend);
        receiveMessage(droid, messageToSend, key);
    }

    public void receiveMessage(Droid droid, String message, int key) {
        System.out.println(droid.name + " получил расшифрованное сообщение: " + decryptMessage(message, key));
    }
}
