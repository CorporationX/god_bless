package faang.school.godbless.droidsecrets;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);

        System.out.printf("Отправлено зашифрованное сообщение: %s\n", encryptedMsg);
        System.out.printf("Получено и расшифровано сообщение: %s\n", msg);
    }
}