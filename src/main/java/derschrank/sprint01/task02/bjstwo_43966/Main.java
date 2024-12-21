package derschrank.sprint01.task02.bjstwo_43966;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> listOfUsers = getListOfUsersWithActivities();
        System.out.println("List of all users: \n" + toStringListOfUsers(listOfUsers));

        Set<Activity> activitiesToSearch = Set.of(Activity.CYCLING,
                Activity.HIKING, Activity.TRAVELING);

        Map<User, Activity> userActivityMap = User.findHobbyLovers(listOfUsers, activitiesToSearch);

        System.out.print("\nMap of users with activities: ");
        System.out.print(activitiesToSearch);
        System.out.print(". Map: \n" + toStringMapOfUsersAndActivity(userActivityMap));
    }

    private static List<User> getListOfUsersWithActivities() {
        List<User> listOfUsers = new ArrayList<>();

        listOfUsers.add(new User(1, "Ivan Ivanov", 28, Set.of(Activity.MUSIC, Activity.HIKING)));
        listOfUsers.add(new User(2, "Petr Petrov", 34, Set.of(Activity.COOKING, Activity.PHOTOGRAPHY)));
        listOfUsers.add(new User(3, "Sergey Smirnov", 19, Set.of(Activity.HIKING, Activity.TRAVELING)));
        listOfUsers.add(new User(4, "Alexey Fedorov", 42, Set.of(Activity.CYCLING, Activity.READING,
                Activity.GARDENING)));
        listOfUsers.add(new User(5, "Andrey Kuznetsov", 22, Set.of(Activity.MUSIC, Activity.CYCLING)));
        listOfUsers.add(new User(6, "Mikhail Sokolov", 31, Set.of(Activity.TRAVELING, Activity.GARDENING,
                Activity.HIKING)));
        listOfUsers.add(new User(7, "Nikolay Pavlov", 29, Set.of(Activity.PHOTOGRAPHY)));
        listOfUsers.add(new User(8, "Dmitry Ivanov", 25, Set.of(Activity.MUSIC, Activity.READING,
                Activity.HIKING)));
        listOfUsers.add(new User(9, "Roman Volkov", 40, Set.of(Activity.COOKING, Activity.CYCLING)));
        listOfUsers.add(new User(10, "Viktor Popov", 21, Set.of(Activity.HIKING, Activity.READING)));
        listOfUsers.add(new User(11, "Anton Lebedev", 37, Set.of(Activity.PHOTOGRAPHY,
                Activity.TRAVELING)));
        listOfUsers.add(new User(12, "Artem Egorov", 18, Set.of(Activity.GARDENING, Activity.COOKING,
                Activity.MUSIC)));
        listOfUsers.add(new User(13, "Stepan Sobolev", 44, Set.of(Activity.CYCLING, Activity.READING)));
        listOfUsers.add(new User(14, "Konstantin Zaytsev", 30, Set.of(Activity.TRAVELING, Activity.HIKING,
                Activity.PHOTOGRAPHY)));
        listOfUsers.add(new User(15, "Vladislav Sorokin", 33, Set.of(Activity.MUSIC,
                Activity.GARDENING)));
        listOfUsers.add(new User(16, "Maxim Vinogradov", 26, Set.of(Activity.COOKING, Activity.READING,
                Activity.CYCLING)));
        listOfUsers.add(new User(17, "Yuri Nikolaev", 24, Set.of(Activity.MUSIC, Activity.PHOTOGRAPHY)));
        listOfUsers.add(new User(18, "Alexandr Belov", 38, Set.of(Activity.HIKING, Activity.GARDENING,
                Activity.CYCLING)));
        listOfUsers.add(new User(19, "Timur Vasiliev", 46, Set.of(Activity.READING, Activity.TRAVELING)));
        listOfUsers.add(new User(20, "Igor Morozov", 20, Set.of(Activity.COOKING, Activity.HIKING,
                Activity.MUSIC)));

        return listOfUsers;
    }

    private static String toStringMapOfUsersAndActivity(Map<User, Activity> mapOfUserActivity) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<User, Activity> userActivityEntry : mapOfUserActivity.entrySet()) {
            result.append(userActivityEntry.getKey());
            result.append(" : ");
            result.append(userActivityEntry.getValue());
            result.append("\n");
        }
        return result.toString();
    }

    private static String toStringListOfUsers(List<User> listOfUsers) {
        StringBuilder result = new StringBuilder();
        for (User user : listOfUsers) {
            result.append(user + "\n");
        }
        return result.toString();
    }
}
