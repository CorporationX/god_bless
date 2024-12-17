package school.faang.sprint_3.task_43557;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        weasleyFamily.addChore("Помыть посуду");
        weasleyFamily.addChore("Подмести пол");
        weasleyFamily.addChore("Приготовить ужин");

        weasleyFamily.performChores();
    }
}
