package faang.school.godbless.droids;

public class Droid {

    private static DroidMessageEncryptor encryptor;

    public static void sendEncryptedMessage(String message, int key) {
        encryptor = ((msg, k) ->
        {
            char[] charArray = msg.toCharArray();
            int temp;
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] >= 'a' && charArray[i] <= 'z') {
                    temp = charArray[i] + k % 'z';
                    temp = (temp <= 'a' - 1) ? 'z' + (temp - 'a' + 1) : temp;
                    charArray[i] = (char) temp;

                }
                if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                    temp = charArray[i] + k % 'Z';
                    temp = (temp <= 'A' - 1) ? 'Z' + (temp - 'A' + 1) : temp;
                    charArray[i] = (char) temp;
                }
            }
            System.out.println(String.valueOf(charArray));
            return String.valueOf(charArray);
        });
        encryptor.crypt(message, key);
    }

    public static void receiveEncryptedMessage(String encryptedMessage, int key) {
        encryptor = ((msg, k) ->
        {
            char[] charArray = msg.toCharArray();
            int temp;
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] >= 'a' && charArray[i] <= 'z') {
                    temp = charArray[i] - k % 'z';
                    temp = (temp <= 'a' - 1) ? 'z' + (temp - 'a' + 1) : temp;
                    charArray[i] = (char) temp;

                }
                if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                    temp = charArray[i] - k % 'Z';
                    temp = (temp <= 'A' - 1) ? 'Z' + (temp - 'A' + 1) : temp;
                    charArray[i] = (char) temp;
                }
            }
            System.out.println(String.valueOf(charArray));
            return String.valueOf(charArray);
        });
        encryptor.crypt(encryptedMessage, key);
    }

    public static void main(String[] args) {
        sendEncryptedMessage("Hello", 1);
        receiveEncryptedMessage("Ifmmp", 1);
    }


}
