package school.faang.BJS2_36779;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> chores = new ArrayList<>(Arrays.asList(
                "Помыть пол",
                "Забрать палочку из магазина",
                "Приготовить обед",
                "Найти коросту"
        ));

        WeasleyFamily weasleyFamily = new WeasleyFamily(chores);
    }
}

