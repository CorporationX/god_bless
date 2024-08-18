package faang.school.godbless.task20977;

public class Main {
    public static void main(String[] args) {
        Droid droid = new Droid();
        DroidMassageReceiver droidReceiver = new DroidMassageReceiver();
        droid.sendEncryptedMessage(droidReceiver, "Hello World!", 2);
        System.out.println(droidReceiver.receiveEncryptedMessage("Hello World!", 2));
    }
}
