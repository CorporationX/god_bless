package faang.school.godbless.elk;

import faang.school.godbless.elk.models.Query;
import faang.school.godbless.elk.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static faang.school.godbless.elk.services.ELKService.*;
import static java.lang.Thread.sleep;

public class Main {

    public static HashMap<User, List<Query>> userQueriesELK = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        User user = new User("test");
        Query query = new Query("test");
        addQueryForUser(user, query);

        sleep(1000);
        query = new Query("test1");
        addQueryForUser(user, query);

        sleep(1000);
        query = new Query("test2");
        addQueryForUser(user, query);
        addQueryForUser(user, query);
        printAllInfoFromELK();
        System.out.println();

        printAllInfoFromELKOrderedByDateCreated();
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

        addUserQueries(anotherUser, queryList);
        printAllInfoFromELK();
        System.out.println();

        sleep(1000);
        Query query4 = new Query("mail");
        addQueryForUser(anotherUser, query4);
        printAllInfoFromELK();
        System.out.println();

        printAllInfoFromELKOrderedByDateCreated();
        System.out.println();

        deleteUserFromELK(user);
        printAllInfoFromELK();

    }
}
