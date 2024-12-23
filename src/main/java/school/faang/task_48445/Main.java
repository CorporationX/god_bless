package school.faang.task_48445;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Chore> chores = List.of(
                new Chore("подмести пол"),
                new Chore("помыть посуду"),
                new Chore("постирать вещи"),
                new Chore("пропылесосить"),
                new Chore("погладить вещи")
        );
        WeasleyFamily family = new WeasleyFamily(chores);
        family.doChores();
    }
}
