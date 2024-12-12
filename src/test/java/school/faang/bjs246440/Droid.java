package school.faang.bjs246440;

public class Droid {
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

    private String decryptMessage(String message, int messageKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, msgKey) ->
                cryptWithAction(msg, msgKey, (chr, key, base) -> (char) ((chr - base + key) % 26 + base));
        return droidMessageEncryptor.encrypt(message, messageKey);
    }

    private String encryptMessage(String message, int messageKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, msgKey) ->
                cryptWithAction(msg, msgKey, (chr, key, base) -> (char) ((chr - base - key + 26) % 26 + base));
        return droidMessageEncryptor.encrypt(message, messageKey);
    }


    public void sendMessage(String message, int key, Droid toDroid) {
        String encryptedMessage = encryptMessage(message, key);
        toDroid.receiveMessage(encryptedMessage, key);
    }

    private void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.printf("%s receive message: %s%n", name, decryptedMessage);
    }

    private String cryptWithAction(String message, int key, CryptAction action) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                ch = action.encrypt(ch, key, Character.isLowerCase(ch) ? 'a' : 'A');
            }
            encryptedMessage.append(ch);
        }
        return encryptedMessage.toString();
    }

    private interface CryptAction {
        Character encrypt(Character character, Integer key, Character base);
    }
}