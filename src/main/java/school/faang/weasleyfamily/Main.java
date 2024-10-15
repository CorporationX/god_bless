package school.faang.weasleyfamily;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> chores = List.of("wash the dishes", "sweep the floor", "cook dinner");
        WeasleyFamily weasleyFamily = new WeasleyFamily(chores);
        weasleyFamily.doChores();
    }
}
