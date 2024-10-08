package school.faangSprint2.t7;

class Droid {
    private String name;

    public Droid(String name) {
        this.name = name;
    }
    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    result.append((char) ((c - base + k) % 26 + base));
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        };
        return encryptor.process(message, key);
    }
    private String decryptMessage(String message, int key) {
        return encryptMessage(message, 26 - (key % 26));
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправляет зашифрованное сообщение: " + encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(name + " получил и расшифровал сообщение: " + decryptedMessage);
    }
}