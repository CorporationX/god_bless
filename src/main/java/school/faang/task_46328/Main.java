package school.faang.task_46328;

public class Main {
    public static void main(String[] args) {
        Droid droid1 = new Droid("Droid1");
        Droid droid2 = new Droid("Droid2");

        int key1 = 3;
        int key2 = 4;

        String message1 = "Пора улетать с этой планеты";
        String message2 = "It's time to get off this planet";

        droid1.sendMessage(message1, key1, droid2);
        droid2.sendMessage(message2, key2, droid1);
    }
}
