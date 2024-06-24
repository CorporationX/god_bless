package faang.school.godbless.Task23_Droids;

public class Main {
    public static void main(String[] args) {

        Droid sender = new Droid();
        Droid receiver = new Droid();
        int key = 3;
        String message = "abcxyz";
        String encryptedMessage = sender.sendEncryptedMessage(message,3);
        System.out.println(encryptedMessage);
        String decryptedMessage = receiver.receiveEncryptedMessage(encryptedMessage,3);
        System.out.println(decryptedMessage);
    }
}
