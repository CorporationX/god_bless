package school.faang.bjs2_91200;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.addTask("Помыть посуду");
        weasleyFamily.addTask("Купить продукты");
        weasleyFamily.addTask("Подмести пол");
        weasleyFamily.addTask("Приготовить ужин");
        weasleyFamily.addTask("Выровнять картину");
        weasleyFamily.addTask("Заправить постель");
        weasleyFamily.doTask();
    }
}
