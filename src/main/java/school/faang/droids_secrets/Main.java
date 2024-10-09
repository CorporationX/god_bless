package school.faang.droids_secrets;

public class Main {
    public static void main(String[] args) {
        Droid firstDroid = new Droid("First");
        Droid secondDroid = new Droid("Second");
        String message = "Hello my friend";
        firstDroid.sendMessage( message, 10, secondDroid);
        System.out.println(message);
        System.out.println(secondDroid.getMessage());
        secondDroid.receiveMessage(secondDroid.getMessage(), 10);
    }
}
