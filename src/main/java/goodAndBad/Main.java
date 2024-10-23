package goodAndBad;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        weasleyFamily.addChore(new Chore("Погулять с собакой"));
        weasleyFamily.printListChore();

        weasleyFamily.addChore(new Chore("Помыть посуду"));
        weasleyFamily.addChore(new Chore("Подмести пол"));
        weasleyFamily.addChore(new Chore("Приготовить ужин"));

        weasleyFamily.execute();
    }
}
