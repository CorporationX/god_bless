package school.faang.task_46179;

public class Main {
    public static void main(String[] args) {
        DroidMessageSystem messageSystem = new DroidMessageSystem();
        Droid droid1 = new Droid(1, "Droid1");
        Droid droid2 = new Droid(2, "Droid2");

        messageSystem.sendMessage(
                10,
                "Hello " + droid2.getName() + "!",
                droid1,
                droid2
        );
    }
}
