package school.faang.BJS2_36779;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Chore> chores = new ArrayList<>();
        chores.add(new Chore("Помыть пол", 25));
        chores.add(new Chore("Забрать палочку из магазина", 10));
        chores.add(new Chore("Приготовить обед", 5));
        chores.add(new Chore("Найти Коросту", 5));

        WeasleyFamily weasleyFamily = new WeasleyFamily(chores);
    }
}

