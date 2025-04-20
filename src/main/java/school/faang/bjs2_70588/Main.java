package school.faang.bjs2_70588;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Вступай в повстанцы!";
        String message2 = "Звезда смерти запущена!";
        int encryptionKey1 = 36;
        int encryptionKey2 = 7;

        r2d2.sendMessage(c3po, message1, encryptionKey1);
        c3po.sendMessage(r2d2, message2, encryptionKey2);
        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);
    }
}
