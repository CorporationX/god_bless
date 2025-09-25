package school.faang.sprint3.chore;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily(List.of("помыть посуду", "подмести пол", "приготовить ужин"));
        weasleyFamily.startChores();
    }
}
