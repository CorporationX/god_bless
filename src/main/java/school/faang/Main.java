package school.faang;

public class Main {
    public static void main(String[] args) {
        Chore[] chores = new Chore[]{new Chore("chore1"), new Chore("chore2"), new Chore("chore3")};
        WeasleyFamily weasleyFamily = new WeasleyFamily(chores);
        weasleyFamily.completeTasks();
    }
}
