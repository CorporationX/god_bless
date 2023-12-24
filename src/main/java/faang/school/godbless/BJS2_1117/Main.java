package faang.school.godbless.BJS2_1117;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        // Отправляем зашифрованное сообщение от r2d2 к c3po
        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        System.out.println(encryptedMsg);

        // Принимаем и расшифровываем сообщение у c3po
        String receivedMsg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println(receivedMsg);
    }
}