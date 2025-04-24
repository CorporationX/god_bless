package school.faang.bjs2_73013;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily(List.of(new Chore("помыть посуду"), new Chore("подмести пол"),
                new Chore("приготовить ужин")));
        weasleyFamily.executeChores();
    }
}