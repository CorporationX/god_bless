package school.faang.bjs2_71714;

public class Droid {

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (message1, key1) -> {
            StringBuilder changedMessage = new StringBuilder();
            for (char a : message1.toCharArray()) {
                if (Character.isLetter(a)) {
                    char base = Character.isLowerCase(a) ? 'a' : 'A';
                    changedMessage.append((char) ((a - base + key1) % 26 + base));
                } else {
                    changedMessage.append(a);
                }
            }
            return changedMessage.toString();
        };

        return droidMessageEncryptor.encryption(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (message1, key1) -> {
            StringBuilder changedMessage = new StringBuilder();
            for (char a : message1.toCharArray()) {
                if (Character.isLetter(a)) {
                    char base = Character.isLowerCase(a) ? 'a' : 'A';
                    changedMessage.append((char) ((a - base - key1) % 26 + base));
                } else {
                    changedMessage.append(a);
                }
            }
            return changedMessage.toString();
        };

        return droidMessageEncryptor.encryption(message, key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println("Sent message: " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println("Received message: " + decryptedMessage);
    }
}
