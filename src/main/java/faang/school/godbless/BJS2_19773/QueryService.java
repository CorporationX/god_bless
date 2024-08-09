package faang.school.godbless.BJS2_19773;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QueryService {
    final Map<User, List<Query>> queries;


    public QueryService(Map<User, List<Query>> queries) {
        this.queries = queries;
    }

    public void addUser(User user, List<Query> userQueries){
        if (queries.containsKey(user)){
            for (Query query : userQueries){
                if (!queries.get(user).contains(query)){
                    queries.get(user).add(query);
                }
            }
        }else{
            queries.put(user, userQueries);
        }
    }

    public void addQuery(User user, Query query){
        if (!queries.containsKey(user)){
            throw new IllegalArgumentException("User does not exist");
        }
        queries.get(user).add(query);
    }

    public void removeUser(User user){
        queries.remove(user);
    }

    public void printQueries(){
        for (Map.Entry<User, List<Query>> entry : queries.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            entry.getValue().sort(Comparator.comparing(Query::getTimestamp));
            entry.getValue().forEach(System.out::println);
        }
    }
}
