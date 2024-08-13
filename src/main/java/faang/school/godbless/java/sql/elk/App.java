package faang.school.godbless.java.sql.elk;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        ElkService elkService = new ElkService();

        List<Query> vasiaQueries = new ArrayList<>();
        User userVasia = new User(1, "Vasia");
        vasiaQueries.add(new Query(1, "Dog"));
        vasiaQueries.add(new Query(2, "Cat"));

        elkService.addNewUserWithQueries(userVasia, vasiaQueries);

        List<Query> koliaQueries = new ArrayList<>();
        User userKolia = new User(2, "Kolia");
        koliaQueries.add(new Query(1, "Monkey"));
        koliaQueries.add(new Query(2, "Taxi"));

        elkService.addNewUserWithQueries(userKolia, koliaQueries);

        elkService.addNewQueryToExistingUser(userVasia, new Query(3, "Train"));


        List<Query> johnQueries = new ArrayList<>();
        User userJohn = new User(3, "John");
        johnQueries.add(new Query(1, "Chocolate"));
        johnQueries.add(new Query(2, "Ice cream"));

        elkService.addNewUserWithQueries(userJohn, johnQueries);
        elkService.deleteUser(userJohn);

        List<Query> maxQueries = new ArrayList<>();
        User userMax = new User(4, "Max");
        maxQueries.add(new Query(1, "Tennis", "2024-06-05T11:50:55"));
        maxQueries.add(new Query(2, "Football", "2024-05-05T22:50:55"));
        maxQueries.add(new Query(3, "Table tennis", "2024-05-05T20:50:55"));

        elkService.addNewUserWithQueries(userMax, maxQueries);

        elkService.showUsersQueries();

        elkService.showUserQueryHistory(userMax);

    }
}
