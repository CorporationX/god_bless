package faang.school.godbless.elk_index_queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    private static final Map<User, List<Query>> queryMap = new HashMap<>();

    public static void main(String[] args) {
        User john = new User( 101, "John" );
        User kyle = new User( 102, "Kyle" );

        Query q1 = new Query( 101, System.currentTimeMillis(), "conent 1" );
        Query q2 = new Query( 102, System.currentTimeMillis(), "conent 2" );
        Query newQuery = new Query( 102, System.currentTimeMillis(), "hello" );

        List<Query> queryList1 = new ArrayList<>();
        List<Query> queryList2 = new ArrayList<>();

        queryList1.add( q1 );
        queryList2.add( q2 );

        Main.addNewUser( john, queryList1 );
        Main.addNewUser( kyle, queryList2 );
        Main.addNewQueryForUser( kyle, newQuery );
        printAllUsersAndQueries();
        System.out.println( "\n" );
        Main.deleteUserAndQueryList( kyle );
        System.out.println( "\n" );
        printAllUsersAndQueries();
    }

    public static void addNewUser(User user, List<Query> queries) {
        queryMap.put( user, queries );
    }

    public static void addNewQueryForUser(User user, Query query) {
        queryMap.computeIfAbsent( user, key -> new ArrayList<>() ).add( query );
    }

    public static void deleteUserAndQueryList(User user) {
        List<Query> queries = queryMap.remove( user );
        if (queries == null) {
            System.out.println( "No such user exist" );
        } else {
            System.out.println( "User: " + user + " with query list " + queries + " was deleted" );
        }
    }

    public static void printAllUsersAndQueries() {
        queryMap.forEach( (k, v) -> System.out.println( k + " " + v ) );
    }
}
