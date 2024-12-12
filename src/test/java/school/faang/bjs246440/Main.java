package school.faang.bjs246440;

public class Main {
    public static void main(String[] args) {
        Droid droid1 = new Droid("first");
        Droid droid2 = new Droid("second");
        int key = 20;

        droid1.sendMessage("we are droids", key, droid2);
        droid2.sendMessage("yep, really we are droids", key, droid1);
        droid1.sendMessage("sh***...", key, droid1);
    }
}
