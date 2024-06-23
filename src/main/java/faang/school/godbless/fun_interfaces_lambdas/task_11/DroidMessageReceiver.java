package faang.school.godbless.fun_interfaces_lambdas.task_11;

public class DroidMessageReceiver {
    public static void receiveEncryptedMessage(Droid droid, int encryptionKey) {
        if (droid.getMessage() == null) {
            System.out.println("Droid doesn't have message");
            return;
        }

        DroidMessageEncryptor encryptor = (message, key) -> {
            char[] messageChars = message.toCharArray();
            for (int i = 0; i < messageChars.length; i++) {
                char ch = messageChars[i];

                if (Character.isLowerCase(ch)) {
                    messageChars[i] = (char) (((ch - 'a' - key + 26)) % 26 + 'a');
                } else if (Character.isUpperCase(ch)) {
                    messageChars[i] = (char) (((ch - 'A' - key) + 26) % 26 + 'A');
                }
            }
            return String.valueOf(messageChars);
        };
        System.out.println(encryptor.encrypt(droid.getMessage(), encryptionKey));
    }

}
