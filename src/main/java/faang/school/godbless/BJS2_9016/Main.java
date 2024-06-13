package faang.school.godbless.BJS2_9016;

public class Main {
    public static void main(String[] args) {
        Droid droid = new Droid();

        int key = 5;

        String message = "Hello";

        String sentMessage = droid.sendEncryptedMessage(message, key);
        String receivedMessage = droid.receiveEncryptedMessage(sentMessage, key);

        System.out.println(sentMessage + "\n" + receivedMessage);

    }
}
