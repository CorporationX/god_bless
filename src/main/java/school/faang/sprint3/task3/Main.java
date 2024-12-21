package school.faang.sprint3.task3;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.addChore(new Chore("Dancing"));
        weasleyFamily.addChore(new Chore("Cooking"));
        weasleyFamily.addChore(new Chore("Washing dishes"));
        weasleyFamily.startExecutingChores();
    }
}
