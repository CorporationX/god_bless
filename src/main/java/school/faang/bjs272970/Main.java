package school.faang.bjs272970;

public class Main {
    public static void main(String[] args) {

        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.addChore(new Chore("Mow the lawn"));
        weasleyFamily.addChore(new Chore("Clean the kitchen"));
        weasleyFamily.addChore(new Chore("Clean the bedroom"));
        weasleyFamily.addChore(new Chore("Sweep the floor"));
        weasleyFamily.addChore(new Chore("Clean the bathroom"));
        weasleyFamily.addChore(new Chore("Clean the garage"));
        weasleyFamily.addChore(new Chore("Clean the kitchen"));
        weasleyFamily.runChores();
    }
}
