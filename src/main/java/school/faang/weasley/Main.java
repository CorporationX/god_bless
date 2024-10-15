package school.faang.weasley;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        weasleyFamily.addChore("Wash the dishes");
        weasleyFamily.addChore("Vacuum the living room");
        weasleyFamily.addChore("Mow the lawn");
        weasleyFamily.addChore("Clean the windows");
        weasleyFamily.addChore("Take out the trash");

        weasleyFamily.executeTasks();
    }
}