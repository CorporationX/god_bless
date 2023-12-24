package faang.school.godbless.droid.secrets;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2", "Hello Cisco!", 1);
        Droid cisco = new Droid("Cisco", "Goodbye, R2D2", 344);
        
        String r2d2Message = r2d2.sendEncryptedMessage(); // Output: Ifmmp xpsme!
        String ciscoMessage = cisco.sendEncryptedMessage(); // Output: Znxuamn znk mrgyy

        cisco.receiveEncryptedMessage(r2d2Message, 1); // Output: Hello Cisco!
        r2d2.receiveEncryptedMessage(ciscoMessage, 344); // Goodbye, R2D2
    }
}
