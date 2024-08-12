package faang.school.godbless.functionalInterfaces.droids;

public class Main {
    public static void main(String[] args) {
        Droid droid = new Droid(13);

        String encryptedMessage = droid.sendEncryptedMessage("Enemy is detected!");
        String decryptedMessage = droid.receiveEncryptedMessage(encryptedMessage, 13);

        System.out.println("Encrypted message: " + encryptedMessage);
        System.out.println("\nDecrypted message: " + decryptedMessage);
    }
}
