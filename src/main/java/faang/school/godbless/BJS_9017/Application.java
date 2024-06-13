package faang.school.godbless.BJS_9017;

public class Application {

    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3p0 = new Droid();
        r2d2.sendEncryptedMessage(c3p0, "May the force be with you", 1);
        c3p0.receiveEncryptedMessage();
    }
}