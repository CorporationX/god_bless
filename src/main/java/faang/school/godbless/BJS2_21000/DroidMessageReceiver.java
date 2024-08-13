package faang.school.godbless.BJS2_21000;

public class DroidMessageReceiver {
    public void receiveEncryptedMessage(String encryptedMessage, int key) {
        StringBuilder decrypted = new StringBuilder();

        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base - key + 26) % 26 + base);
            }
            decrypted.append(c);
        }
        System.out.println("Сообщение: " + decrypted);
    }
}
