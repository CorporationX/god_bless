package droidSecret;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid r1d1 = new Droid();
        int code = 5;
        String encryptedMsg = r2d2.sendEncryptMessage("Hello!zzb", code);
        r1d1.receiveEncryptMessage(encryptedMsg, code);
    }
}
