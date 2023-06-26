package faang.school.godbless.Sprint3.task15;

public class Application {
    public static void main(String[] args) {
        Droid sender = new Droid();
        Droid receiver = new Droid();

        String message = "I am robot";
        int key = 3;
        String encrypted = sender.sendMessage(message, key, null);
        String original = receiver.receiverMessage(encrypted, key, null);
        System.out.println(encrypted);
        System.out.println(original);
    }
}
