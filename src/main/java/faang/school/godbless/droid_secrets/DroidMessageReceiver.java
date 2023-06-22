package faang.school.godbless.droid_secrets;

class DroidMessageReceiver {
    public static void receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                int originalPosition = m.charAt(i);
                char newCh = (char) (originalPosition - k);
                result.append(newCh);
            }
            return result.toString();
        };
        System.out.println(droidMessageEncryptor.encrypt(encryptedMessage, key));
    }
}
