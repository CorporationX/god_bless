package school.faang.bjs2_89663;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");
        WeasleyFamily family = new WeasleyFamily(chores);
        family.startHomework();
    }
}