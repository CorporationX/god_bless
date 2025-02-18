package school.faang.BJS2_60708;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeasleyFamily weasleyFamily = new WeasleyFamily(List.of(
                new Chore("помыть посуду"),
                new Chore("подмести пол"),
                new Chore("приготовить ужин")
        ));

        weasleyFamily.actionsCore();
    }
}
