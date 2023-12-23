package faang.school.godbless.droid.secrets;

public class Main {
    public static void main(String[] args) {
        Droid droid = new Droid("R2D2", "Hello world!", 1);
        droid.sendEncryptedMessage(); // Output: Ifmmp xpsme!

        Droid newDroid = new Droid("Cisco", "Through the glass", 344);
        newDroid.sendEncryptedMessage(); // Output: Znxuamn znk mrgyy
    }
}
