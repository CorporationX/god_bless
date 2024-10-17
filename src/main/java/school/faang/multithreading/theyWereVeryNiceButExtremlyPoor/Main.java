package school.faang.multithreading.theyWereVeryNiceButExtremlyPoor;

public class Main {
    public static void main(String[] args) {
        Chore washTheDishes = new Chore("wash the dishes");
        Chore sweepTheFloor = new Chore("sweep the floor");
        Chore cookDinner = new Chore("cook dinner");
        Chore ironThings = new Chore("iron things");

        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.addChore(washTheDishes);
        weasleyFamily.addChore(sweepTheFloor);
        weasleyFamily.addChore(cookDinner);
        weasleyFamily.addChore(ironThings);

        weasleyFamily.executeChores();
    }
}
