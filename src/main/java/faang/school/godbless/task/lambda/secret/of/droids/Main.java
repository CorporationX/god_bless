package faang.school.godbless.task.lambda.secret.of.droids;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        // Не зашифрованное сообщение
        System.out.println("Не зашифрованное сообщение: " + message);

        // Зашифрованное сообщение
        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        System.out.println("Зашифрованное сообщение: " + encryptedMsg);

        // Расшифрованное сообщение
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println("Расшифрованное сообщение: " + msg);
    }
}
