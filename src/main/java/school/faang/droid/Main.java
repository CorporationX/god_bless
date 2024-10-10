package school.faang.droid;

public class Main {
    public static void main(String[] args) {
        Droid battleDroidB1 = new Droid("B1 Battle Droid");
        Droid battleDroidB2 = new Droid("Battle Droid B2-RP");
        Droid r2d2 = new Droid("R2-D2");

        String message1 = "How are you doing, partner?";
        String message2 = "Everything is fine, but the boards are a bit glitchy!";
        String message3 = "We have intercepted your communication channel! We will destroy you all!";

        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        battleDroidB1.sendMessage(battleDroidB2, message1, encryptionKey2);
        battleDroidB2.sendMessage(battleDroidB1, message2, encryptionKey1);
        r2d2.sendMessage(battleDroidB2, message3, encryptionKey2);
    }
}
