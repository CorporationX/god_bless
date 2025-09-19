package school.faang.bjs2_90990;

public class Main {
    private static final int DEAFAULT_KEY = 1;

    public static void main(String[] args) {
        Droid senderDroid = new Droid();
        Droid receiverDroid = new Droid();
        String message = "Encrypt me!";

        senderDroid.sendMessage(message, DEAFAULT_KEY, receiverDroid);
    }
}
