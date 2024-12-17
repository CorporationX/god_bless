package school.faang.sprint3.task_48315;

public class Main {
    public static void main(String[] args) {
        WesleyFamily family =  new WesleyFamily();

        family.addChore(new Chore("Wash dishes"));
        family.addChore(new Chore("Lay the table"));
        family.addChore(new Chore("Clean bathroom"));

        family.doChores();
    }
}
