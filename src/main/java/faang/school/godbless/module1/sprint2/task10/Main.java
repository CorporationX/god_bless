package faang.school.godbless.module1.sprint2.task10;

public class Main {
    public static void main(String[] args) {
        Droid droid1 = new Droid("Droid", "text");
        Droid droid2 = new Droid("Droid2", "text2");

        droid1.sendEncryptedMessage(droid2, "Hello", 5);
        DroidMessageReceiver droidMessageReceiver = new DroidMessageReceiver(droid2);
        droidMessageReceiver.receiveEncryptedMessage(droid2.getMessage(), 5);

    }
}
