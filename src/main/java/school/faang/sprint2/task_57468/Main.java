package school.faang.sprint2.task_57468;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid cp0 = new Droid("CP0");

        int key = 3;

        try {
            r2d2.sendMessage("Hello!", key, cp0);
            cp0.sendMessage("Hello!", key, r2d2);
            r2d2.sendMessage("How are you?", key, cp0);
            cp0.sendMessage("Im fine, and you?", key, r2d2);
            r2d2.sendMessage("Im too!", key, cp0);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
