package school.faang.task_46441;

public class Droid {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMsg = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMsg);
        droid.receiveMessage(encryptedMsg, key);
    }

    private void receiveMessage(String message, int key) {
        String decryptMessage = decryptMessage(message, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptMessage);
    }

    private String encryptMessage(String msg, int key) {
        DroidMessageEncryptor anigma = (message, shift) -> {
            var encryptedMsg = new StringBuilder();
            String lowerCaseMsg = message.toLowerCase();
            for (int i = 0; i < lowerCaseMsg.length(); i++) {
                boolean isUpperCase = Character.isUpperCase(message.charAt(i));
                if (ALPHABET.indexOf(lowerCaseMsg.charAt(i)) != -1) {
                    int index = ALPHABET.indexOf(lowerCaseMsg.charAt(i));
                    int keyId = index + shift;
                    if (keyId > ALPHABET.length() - 1) {
                        keyId = keyId - ALPHABET.length();
                    }
                    if (isUpperCase) {
                        encryptedMsg.append(String.valueOf(ALPHABET.charAt(keyId)).toUpperCase());
                    } else {
                        encryptedMsg.append(ALPHABET.charAt(keyId));
                    }
                } else {
                    encryptedMsg.append(lowerCaseMsg.charAt(i));
                }
            }
            return encryptedMsg.toString();
        };
        return anigma.shift(msg, key);
    }

    private String decryptMessage(String msg, int key) {
        DroidMessageEncryptor alanTuring = (message, shift) -> {
            var encryptedMsg = new StringBuilder();
            String lowerCaseMsg = msg.toLowerCase();
            for (int i = 0; i < lowerCaseMsg.length(); i++) {
                boolean isUpperCase = Character.isUpperCase(message.charAt(i));
                if (ALPHABET.indexOf(lowerCaseMsg.charAt(i)) != -1) {
                    int index = ALPHABET.indexOf(lowerCaseMsg.charAt(i));
                    int keyId = index - key;
                    if(keyId < 0) {
                        keyId = ALPHABET.length() + keyId;
                    }
                    if (isUpperCase) {
                        encryptedMsg.append(String.valueOf(ALPHABET.charAt(keyId)).toUpperCase());
                    } else {
                        encryptedMsg.append(ALPHABET.charAt(keyId));
                    }
                } else {
                    encryptedMsg.append(lowerCaseMsg.charAt(i));
                }
            }
            return encryptedMsg.toString();
        };

        return alanTuring.shift(msg, key);
    }
}
