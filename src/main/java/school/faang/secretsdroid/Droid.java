package school.faang.secretsdroid;

public class Droid {
    private static final Integer SIZE_ALPHABET = 26;

    private String name;

    public Droid(String name) {
        this.name = name;
    }

    private DroidMessageEncryptor encryptor = (message, key) -> {
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            if(Character.isLetter(message.charAt(i))){
                char startCharacter = Character.isUpperCase(message.charAt(i)) ? 'A' : 'a';
                encryptedMessage += (char) ((message.charAt(i) - startCharacter + key) % SIZE_ALPHABET + startCharacter);
            } else {
                encryptedMessage += message.charAt(i);
            }
        }
        return encryptedMessage;
    };
    public String encryptMessage(String message, Integer key){
        return encryptor.crypto(message, key);
    }

    public String decryptMessage(String message, Integer key) {
        return encryptor.crypto(message, SIZE_ALPHABET-key);
    }

    public void sendMessage(Droid droid, String message, Integer key) {
        String cryptedMessage = encryptMessage(message, key);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + cryptedMessage);
        droid.receiveMessage(cryptedMessage, key);
    }

    public void receiveMessage(String message, Integer key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(this.name + " получил расшифрованное сообщение: " + decryptedMessage);
    }

}