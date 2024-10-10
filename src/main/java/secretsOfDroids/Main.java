package secretsOfDroids;

public class Main {
    public static void main(String[] args) {
        // Создаём много дроидов
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");
        Droid hk47 = new Droid("HK-47");
        Droid hk50 = new Droid("HK-50");

        // Оригинальные сообщения
        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        String message3 = "The Republic is coming!";
        int encryptionKey1 = 3; // Ключ шифрования для первого сообщения
        int encryptionKey2 = 7; // Ключ шифрования для второго сообщения
        int encryptionKey3 = 9; // Ключ шифрования для третьего сообщения

        // R2D2 отправляет сообщение C3PO
        r2d2.sendMessage(c3po, message1, encryptionKey1);

        // C3PO отвечает R2D2
        c3po.sendMessage(r2d2, message2, encryptionKey2);

        // BB-8 отправляет сообщение C3PO
        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);

        // HK-47 оправляет сообщение HK-50
        hk47.sendMessage(hk50, message3, encryptionKey3);
    }
}