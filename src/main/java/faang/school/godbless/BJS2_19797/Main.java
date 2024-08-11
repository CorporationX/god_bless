package faang.school.godbless.BJS2_19797;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ElkQueryIndexService service = new ElkQueryIndexService();
        service.putUserWithQueries(new User(1, "Robert"),
                new ArrayList<>(List.of(new Query(1, "FAANG"))));
        service.putUserWithQueries(new User(2, "Dasha"),
                new ArrayList<>(List.of(new Query(2, "FAANG"), new Query(3, "VK"))));
        service.putUserWithQueries(new User(3, "Vlad"),
                new ArrayList<>(List.of(new Query(4, "SBER"), new Query(5, "VK"), new Query(5, "YOUTUBE"))));

        service.printUserQueries();
        System.out.println();

        System.out.println(service.putUserForQuery(new User(3, "Vlad"), new Query(123, "YANDEX")));
        System.out.println(service.putUserForQuery(new User(3, "Anna"), new Query(1001, "YANDEX")));
        System.out.println();

        service.printUserQueries();
        System.out.println();

        service.removeUser(new User(1, "Robert"));
        System.out.println();

        service.printUserQueries();
        System.out.println();

        service.printUserQueriesWithSorting();
    }
}
