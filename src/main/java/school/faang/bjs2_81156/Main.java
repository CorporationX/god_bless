package school.faang.bjs2_81156;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Chore> chores = List.of(
                new Chore("помыть посуду"),
                new Chore("подготовиться к сессии"),
                new Chore("еще какое-то дело"),
                new Chore("И еще одно дело")
        );

        WeasleyFamily weasleyFamily = new WeasleyFamily(chores);
        weasleyFamily.doHomeWork();
    }
}
