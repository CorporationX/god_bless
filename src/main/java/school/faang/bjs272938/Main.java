package school.faang.bjs272938;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily family = new WeasleyFamily(List.of(
                new Chore("помыть посуду"), new Chore("подмести пол"), new Chore("приготовить ужин")));

        family.doAllChores();
    }
}
