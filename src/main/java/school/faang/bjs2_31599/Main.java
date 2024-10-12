package school.faang.bjs2_31599;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        testGroupUsersByAgeWithNullList();
        testGroupUsersByAgeWithNullUserInList();
        testGroupUsersByAgeWithNullAgeInUser();
        testGroupUsersByAgeWthValidUserList();
    }

    private static void testGroupUsersByAgeWithNullList() {
        System.out.println("TestGroupUsersByAgeWithNullList");
        try {
            User.groupUsers(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static void testGroupUsersByAgeWithNullUserInList() {
        System.out.println("\nTestGroupUsersByAgeWithNullUserInList");

        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("Алексей", 25, "Google", "Москва, ул. Ленина, 10"),
                null,
                new User("Иван", 25, "Sberbank", "Москва, ул. Тверская, 15"),
                new User("Анна", 35, "Mail.ru", "Казань, ул. Баумана, 50"),
                new User("Дмитрий", 30, "Ozon", "Новосибирск, Красный проспект, 100"),
                new User("Светлана", 22, "Tinkoff", "Москва, ул. Варшавское шоссе, 200"),
                null,
                new User("Ольга", 22, "Avito", "Санкт-Петербург, ул. Марата, 12"),
                new User("Николай", 35, "Ростелеком", "Воронеж, ул. Плехановская, 89")
        ));
        groupAndPrintUsersByAge(userList);
    }

    private static void testGroupUsersByAgeWithNullAgeInUser() {
        System.out.println("\nTestGroupUsersByAgeWithNullAgeInUser");

        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("Алексей", 25, "Google", "Москва, ул. Ленина, 10"),
                new User("Иван", 25, "Sberbank", "Москва, ул. Тверская, 15"),
                new User("Анна", null, "Mail.ru", "Казань, ул. Баумана, 50"),
                new User("Дмитрий", 30, "Ozon", "Новосибирск, Красный проспект, 100"),
                new User("Светлана", 22, "Tinkoff", "Москва, ул. Варшавское шоссе, 200"),
                new User("Ольга", null, "Avito", "Санкт-Петербург, ул. Марата, 12"),
                new User("Николай", 35, "Ростелеком", "Воронеж, ул. Плехановская, 89")
        ));
        groupAndPrintUsersByAge(userList);
    }

    private static void testGroupUsersByAgeWthValidUserList() {
        System.out.println("\nTestGroupUsersByAgeWthValidUserList");
        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("Алексей", 25, "Google", "Москва, ул. Ленина, 10"),
                new User("Иван", 25, "Sberbank", "Москва, ул. Тверская, 15"),
                new User("Дмитрий", 30, "Ozon", "Новосибирск, Красный проспект, 100"),
                new User("Светлана", 22, "Tinkoff", "Москва, ул. Варшавское шоссе, 200"),
                new User("Николай", 22, "Ростелеком", "Воронеж, ул. Плехановская, 89")
        ));
        groupAndPrintUsersByAge(userList);
    }

    private static void groupAndPrintUsersByAge(List<User> userList) {
        System.out.println("the initial number of users in the list = " + userList.size());

        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(userList);

        int countUsers = 0;

        for (Map.Entry<Integer, List<User>> userByAgeEntry : groupedUsersByAge.entrySet()) {
            System.out.print(userByAgeEntry.getKey() + " ");
            System.out.println(userByAgeEntry.getValue());
            countUsers += userByAgeEntry.getValue().size();
        }
        System.out.println("sum users = " + countUsers);
    }


}
