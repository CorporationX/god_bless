package school.faang.moduleone.sprinttwo.task_43531;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2", Main::encryptByCezarMethod);
        Droid c3po = new Droid("C3PO", (Main::encryptByCezarMethod));
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        String encryptedMessage1 = r2d2.sendMessage(c3po, message1, encryptionKey1);
        String encryptedMessage2 = c3po.sendMessage(r2d2, message2, encryptionKey2);

        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);

        c3po.receiveMessage(encryptedMessage1, encryptionKey1);
        r2d2.receiveMessage(encryptedMessage2, encryptionKey2);
    }

    private static String encryptByCezarMethod(String message, int encryptionKey) {
        encryptionKey = encryptionKey % 26;
        if (encryptionKey < 0) {
            encryptionKey = encryptionKey * -1;
        }
        char[] source = message.toCharArray();
        char[] result = new char[message.length()];
        for (int i = 0; i < source.length; i++) {
            if (source[i] >= 65 && source[i] <= 90) {
                result[i] = (char) ((source[i] - 65 + encryptionKey) % 26 + 65);
            } else if (source[i] >= 97 && source[i] <= 122) {
                result[i] = (char) ((source[i] - 97 + encryptionKey) % 26 + 97);
            } else {
                result[i] = source[i];
            }
        }
        return String.valueOf(result);
    }
}
