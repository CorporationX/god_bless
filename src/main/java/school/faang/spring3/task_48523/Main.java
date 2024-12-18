package school.faang.spring3.task_48523;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.getChoreList().add(new Chore("Помыть посуду"));
        weasleyFamily.getChoreList().add(new Chore("Помыть пол"));
        weasleyFamily.getChoreList().add(new Chore("Приготовить ужин"));
        weasleyFamily.doChores();
    }
}
