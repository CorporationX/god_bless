package school.faang.encryption;

public class Main {

    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        String message1 = "Join the Rebellion!";
        String message2 = "May the Force be with you.";
        int encryptKey1 = 4;
        int encryptKey2 = 8;
        r2d2.sendMessage(c3po, message1, encryptKey1);
        c3po.sendMessage(r2d2, message2, encryptKey2);
    }
}