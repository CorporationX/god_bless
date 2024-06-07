package faang.school.godbless.query_index;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        QueryManager queryManager = new QueryManager();

        Query query1 = new Query(1, "First", 100);
        Query query2 = new Query(2, "Second", 1);
        Query query3 = new Query(3, "Third", 23);
        Query query4 = new Query(4, "Fourth", 4);
        Query query5 = new Query(5, "Fifth", 153);
        Query query6 = new Query(6, "Sixth", 133);

        List<Query> queries = List.of(query1, query2, query3, query4, query5);


        User user = new User(1, "SomeUser");

        queryManager.addNewUserAndQueries(user, queries);
        queryManager.showUsersAndQueries();
        System.out.println();

        queryManager.addQueriesToUser(user, query6);
        queryManager.showUsersAndQueries();
        System.out.println();

        queryManager.deleteUserAndQueries(user);
        queryManager.deleteUserAndQueries(user);

        queryManager.showUserHistory(user);
    }
}
