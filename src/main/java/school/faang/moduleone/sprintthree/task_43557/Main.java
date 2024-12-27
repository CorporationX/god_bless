package school.faang.moduleone.sprintthree.task_43557;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        weasleyFamily.addChores(
                "помыть посуду",
                "подмести пол",
                "приготовить ужин"
        );

        weasleyFamily.doAllChores();
    }
}
