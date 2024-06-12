package faang.school.godbless.Droids;

public class Main {
    public static void main(String[] args) {

        Droid testDroid = new Droid();
        int key = 3;
        String message = "hello";
        String msg = testDroid.sendEncryptedMessage(message,3);
        System.out.println(msg);

    }
}
