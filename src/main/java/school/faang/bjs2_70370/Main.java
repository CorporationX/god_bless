package school.faang.bjs2_70370;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        DroidService droidService = new DroidService();

        droidService.sendMessage(r2d2, c3po, "Join the Rebellion!", 3);
        droidService.sendMessage(c3po, r2d2, "The Death Star is operational!", 7);
        droidService.sendMessage(bb8, c3po, "The mission is complete.", 3);
    }
}
