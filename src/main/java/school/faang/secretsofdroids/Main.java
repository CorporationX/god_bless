package school.faang.secretsofdroids;

public class Main {
    public static void main(String[] args) {
        // Создаём трёх дроидов
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        // Оригинальные сообщения
        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3; // Ключ шифрования для первого сообщения
        int encryptionKey2 = 7; // Ключ шифрования для второго сообщения

        // R2D2 отправляет сообщение C3PO
        r2d2.sendMessage(message1, encryptionKey1, c3po);

        // C3PO отвечает R2D2
        c3po.sendMessage(message2, encryptionKey2, r2d2);

        // BB-8 отправляет сообщение C3PO
        bb8.sendMessage("The mission is complete.", encryptionKey1, c3po);
    }
}
