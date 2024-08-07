package faang.school.godbless.bjs2_18495;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        var user1 = new User("Ivan", 20, "Sber", "Moscow");
        var user2 = new User("Ivan", 20, "Sber", "Moscow");
        var user3 = new User(null, null, null, null);
        var user4 = new User("x", null, "x", "x");
        var user5 = new User("Alexander", 25, "Epam", "Minsk");

        var users = asList(user1, user2, user3, user4, user5);

        var groupedUsersByAgeCheckValue = User.groupUsersByAgeCheckValue(users);
        User.printUsersGroupedByAge(groupedUsersByAgeCheckValue);
        System.out.println("----");
        var groupedUsersByAgeCheckKey = User.groupUsersByAgeCheckKey(users);
        User.printUsersGroupedByAge(groupedUsersByAgeCheckKey);
        System.out.println("----");
        var groupedUsersByAgeJava8ForEach = User.groupUsersByAgeJava8ForEach(users);
        User.printUsersGroupedByAge(groupedUsersByAgeJava8ForEach);
        System.out.println("----");
        var groupedUsersByAgeJava8GroupingBy = User.groupUsersByAgeJava8GroupingBy(users);
        User.printUsersGroupedByAge(groupedUsersByAgeJava8GroupingBy);
        System.out.println("----");
        var groupedUsersByAgeJava8ToMap = User.groupUsersByAgeJava8ToMap(users);
        User.printUsersGroupedByAge(groupedUsersByAgeJava8ToMap);
    }
}
