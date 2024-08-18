package faang.school.godbless.elk;

import faang.school.godbless.elk.models.Query;
import faang.school.godbless.elk.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.elk.services.ELKService.*;
import static java.lang.Thread.sleep;

public class Main {

    private static Map<User, List<Query>> userQueriesELK = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        User user = new User("test");
        Query query = new Query("test");
        addQueryForUser(user, query, userQueriesELK);

        sleep(1000);
        query = new Query("test1");
        addQueryForUser(user, query, userQueriesELK);

        sleep(1000);
        query = new Query("test2");
        addQueryForUser(user, query, userQueriesELK);
        addQueryForUser(user, query, userQueriesELK);
        printAllInfoFromELK(userQueriesELK);
        System.out.println();

        printAllInfoFromELKOrderedByDateCreated(userQueriesELK);
        System.out.println();

        User anotherUser = new User("test");
        Query query1 = new Query("google");
        sleep(1000);
        Query query2 = new Query("yandex");
        sleep(1000);
        Query query3 = new Query("yahoo");
        List<Query> queryList = new ArrayList<>();
        queryList.add(query1);
        queryList.add(query2);
        queryList.add(query3);

        addUserQueries(anotherUser, queryList, userQueriesELK);
        printAllInfoFromELK(userQueriesELK);
        System.out.println();

        sleep(1000);
        Query query4 = new Query("mail");
        addQueryForUser(anotherUser, query4, userQueriesELK);
        printAllInfoFromELK(userQueriesELK);
        System.out.println();

        printAllInfoFromELKOrderedByDateCreated(userQueriesELK);
        System.out.println();

        deleteUserFromELK(user, userQueriesELK);
        printAllInfoFromELK(userQueriesELK);
    }
}
