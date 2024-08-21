package faang.school.godbless.SecondSprint.BJS2_20999;

public class Droid {
    String s = "abcdefghijklmnopqrstuvwxyz!?., ";

    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println(encryptedMsg);
        System.out.println(msg);
    }

    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            char[] chars = m.toLowerCase().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int indexNew = (s.indexOf(chars[i]) + k) % s.length();
                chars[i] = s.charAt(indexNew);
            }
            return String.valueOf(chars);
        };
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            char[] chars = m.toLowerCase().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int indexNew = (s.indexOf(chars[i]) + (s.length() - k)) % s.length();
                chars[i] = s.charAt(indexNew);
            }
            return String.valueOf(chars);
        };
        return encryptor.encrypt(message, key);
    }
}

