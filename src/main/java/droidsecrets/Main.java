package droidsecrets;

public class Main {
    public static void main(String[] args) {
        Droid droid1 = new Droid("Droid1");
        Droid droid2 = new Droid("Droid2");
        Droid droid3 = new Droid("Droid3");

        droid1.sendMessage("Join the Rebellion!", 3, droid2);
        droid2.sendMessage("The Death Star is operational!", 7, droid3);
        droid3.sendMessage("The mission is complete.", 3, droid1);
    }
}
