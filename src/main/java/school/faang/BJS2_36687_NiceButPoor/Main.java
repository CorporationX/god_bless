package school.faang.BJS2_36687_NiceButPoor;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily family = new WeasleyFamily();
        family.addChore("wash the dishes");
        family.addChore("sweep the floor");
        family.addChore("cook dinner");

        family.doChores();
    }
}
