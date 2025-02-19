package school.faang.sprint.third.works;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Chore> chores = List.of(new Chore("Вымыть пол"), new Chore("Помыть посуду"), new Chore("Поспать"));
        WeasleyFamily weasleyFamily = new WeasleyFamily(chores);
        weasleyFamily.doChores();
    }
}
