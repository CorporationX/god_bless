package school.faang.task_48189;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        weasleyFamily.addChore("wash the dishes");
        weasleyFamily.addChore("sweep the floor");
        weasleyFamily.addChore("cook dinner");

        weasleyFamily.solveChores();
    }
}
