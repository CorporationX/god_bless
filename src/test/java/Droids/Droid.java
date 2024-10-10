package Droids;

public class Droid {
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : m.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + k) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (m, k) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : m.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - k + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(message, key);  // сообщение
    }

    public void sendMessage(String message, int key, Droid droid) {
        String encryptMessageStr = encryptMessage(message, key);
        System.out.println(this.getName() + "  send  encryption message " + encryptMessageStr);
        droid.receiveMessage(encryptMessageStr, key);
    }

    public void receiveMessage(String message, int key) {
        String decriptMessageStr = decryptMessage(message, key);
        System.out.println(this.getName() + "  reseive  decription message " + decriptMessageStr);
    }
}



