package school.faang.bjs2_85461;

import java.util.Comparator;

public class AgeComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getAge() - o2.getAge();
    }
}
