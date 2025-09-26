package weasley;

public class Main {
    public static void main(String[] args) {
        String [] chores = {"Помыть посуду", "Сделать уроки", "Приготовить ужин"};

        WeasleyFamily weasleyFamily = new WeasleyFamily(chores);

        weasleyFamily.doTasks();
    }
}
