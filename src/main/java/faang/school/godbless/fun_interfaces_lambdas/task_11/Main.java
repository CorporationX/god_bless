package faang.school.godbless.fun_interfaces_lambdas.task_11;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 10;

        r2d2.sendEncryptedMessage(c3po, message, encryptionKey);
        DroidMessageReceiver.receiveEncryptedMessage(c3po, encryptionKey);
    }
}
