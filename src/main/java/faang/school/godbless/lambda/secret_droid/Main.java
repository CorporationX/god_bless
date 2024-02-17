package faang.school.godbless.lambda.secret_droid;

public class Main {
    public static void main(String[] args) {
        Droid d1d3 = new Droid();
        Droid a131 = new Droid();
        String message = "ABC";
        int encryptionKey = 24;

        String enctyptWord = d1d3.sendEncryptedMessage(message, encryptionKey);
        System.out.println(enctyptWord);
        String msg = a131.receiveEncryptedMessage(enctyptWord, encryptionKey);
        System.out.println(msg);

    }
}
