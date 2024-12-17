package school.faang.sprint_2.task_46420;

public record Droid(String name) {

    public String encryptMessage(String message, int key) {
        return processMessage(message, key);
    }

    public String decryptMessage(String message, int key) {
        return processMessage(message, -key);
    }

    public void sendMessage(Droid recipient, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMessage);
        recipient.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptedMessage);
    }

    private String processMessage(String message, int key) {
        return message.chars()
                .mapToObj(c -> (char) c)
                .map(c -> shiftCharacter(c, key))
                .map(String::valueOf)
                .reduce("", String::concat);
    }

    private char shiftCharacter(char c, int key) {
        if (Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) ((c - base + key + 26) % 26 + base);
        }
        return c;
    }
}

