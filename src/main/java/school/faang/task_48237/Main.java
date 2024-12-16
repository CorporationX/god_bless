package school.faang.task_48237;

public class Main {
    private static final WeasleyFamily weasleyFamily = new WeasleyFamily();

    public static void main(String[] args) {
        initData();

        weasleyFamily.doAllChores();
    }

    private static void initData() {
        weasleyFamily.addChore(new Chore(ChoreType.A));
        weasleyFamily.addChore(new Chore(ChoreType.B));
        weasleyFamily.addChore(new Chore(ChoreType.C));
    }

}
