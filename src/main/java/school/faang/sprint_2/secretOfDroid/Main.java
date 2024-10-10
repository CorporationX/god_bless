package school.faang.sprint_2.secretOfDroid;

public class Main {

    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        // Оригинальные сообщения
        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3; // Ключ шифрования для первого сообщения
        int encryptionKey2 = 7; // Ключ шифрования для второго сообщения

        r2d2.sendMessage(message1, encryptionKey1, c3po);
        c3po.sendMessage(message2, encryptionKey2, c3po);
        bb8.sendMessage("The mission is complete.", encryptionKey1, c3po);
    }
}
