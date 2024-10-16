package school.faang.godbless.bjs2_36735;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeasleyFamily family = new WeasleyFamily();
        family.addChore("Wash dishes 1");
        family.addChore("Mop the floor 1");
        family.addChore("Wash dishes 2");
        family.addChore("Clean the snow");
        family.addChore("Wash dishes 3");
        family.addChore("Mop the floor 2");
        family.addChore("Wash dishes 4");
        family.addChore("Cook");
        family.addChore("Wash dishes 5");
        family.addChore("Mop the floor 3");
        family.doChores();
    }
}
