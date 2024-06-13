package faang.school.godbless.task24;

public class Main {
    public static void main(String[] args) {
        Droid droid1 = new Droid();
        Droid droid2 = new Droid();

        String message = "Hello, Droid!";
        int key = 3;

        droid1.sendEncryptedMessage(droid2, message, key);
    }
}
