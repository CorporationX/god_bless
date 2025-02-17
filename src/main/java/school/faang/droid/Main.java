package school.faang.droid;

public class Main {
    public static void main(String[] args) {
        Droid b00t = new Droid("B00T");
        Droid wh0 = new Droid("W-H0");
        Droid j4v4 = new Droid("J4V4");

        String message1 = "Beep-boop-beep!";
        String message2 = "I’m just a piece of junk.";
        String message3 = "We're doomed!";
        int encryptionKey1 = 2;
        int encryptionKey2 = 5;
        int encryptionKey3 = 3;

        b00t.sendMessage(wh0, message1, encryptionKey1);
        wh0.receivedMessage(message2, encryptionKey2);

        wh0.sendMessage(b00t, message2, encryptionKey2);
        b00t.receivedMessage(message1, encryptionKey1);

        j4v4.sendMessage(b00t, message3, encryptionKey3);
        b00t.receivedMessage(message3, encryptionKey3);
    }
}
