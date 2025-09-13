package school.faang.user.grouping;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User testUser1 = new User("Iya", 24, "AviaBriefing", "Saint Petersburg");
        User testUser2 = new User("Barbie", 24, "Barbie", "Random House");
        User testUser3 = new User("Ken", 25, "Ken", "Random House");
        System.out.println(User.groupUsers(List.of(testUser1, testUser2, testUser3)));
    }
}
