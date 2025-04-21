package school.faang.bjs270448;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptedKey) -> {
            StringBuilder result = new StringBuilder();
            for (char character : msg.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isUpperCase(character) ? 'A' : 'a';
                    result.append((char) ((character - base + encryptedKey) % 26 + base));
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msg, encryptedKey) -> {
            StringBuilder result = new StringBuilder();
            for (char character : msg.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isUpperCase(character) ? 'A' : 'a';
                    result.append((char) ((character - base - encryptedKey + 26) % 26 + base));
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        };
        return decryptor.encrypt(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(this.name + " получил сообщение: " + decryptedMessage);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(this.name + " отправил сообщение: " + encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }
}

