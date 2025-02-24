package school.faang.BJS236364;

import java.util.ArrayList;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        List<PigThread> pigThreadList = new ArrayList<>();
        pigThreadList.add(new Pig1Thread("Ниф-Ниф", "Солома"));
        pigThreadList.add(new Pig2Thread("Нуф-Нуф", "Дерево"));
        pigThreadList.add(new Pig3Thread("Наф-Наф", "Кирпич"));
        pigThreadList.forEach(Thread::start);
    }
}
