package school.faang.task_48732;

public class Main {

    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};
        WeasleyFamily weasleyFamily = new WeasleyFamily(chores);
        weasleyFamily.executeChores();
    }
}
