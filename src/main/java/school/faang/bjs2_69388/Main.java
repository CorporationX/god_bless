package school.faang.bjs2_69388;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var max = new User("Max", 17, "Facebook", "New York");
        var lev = new User("Lev", 19, "Amazon", "Moscow");
        var din = new User("Din", 19, "Apple", "Dubai");
        var kim = new User("Kim", 17, "Netflix", "Pyongyang");
        var ray = new User("Ray", 19, "Google", "Georgetown");

        var groupedUsers = User.groupUsers(List.of(max, lev, din, kim, ray));
        for (int age : groupedUsers.keySet()) {
            System.out.printf("%d %d -- %s\n", age, groupedUsers.get(age).size(), groupedUsers.get(age));
        }
    }
}
