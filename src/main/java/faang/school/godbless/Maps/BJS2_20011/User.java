package faang.school.godbless.Maps.BJS2_20011;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@EqualsAndHashCode
@Getter
public class User {
    private final int id;
    private String name;
    @EqualsAndHashCode.Exclude
    private List<Query> queries = new ArrayList<>();

    public User(String name) {
        this.name = name;
        id = ThreadLocalRandom.current().nextInt(1, 1000);
    }

    public List<Query> addQuery(Query query) {
        queries.add(query);
        return queries;
    }

    public List<Query> addQuery(List<Query> queryList) {
        queries.addAll(queryList);
        return queries;
    }

//    public void printQueries() {
//        for (Query query : queries) {
//            System.out.println(query.getId() + ":" + query.getContent());
//        }
//    }
    public List<Query> getSortedQuryList(){
        Collections.sort(queries, (a, b) -> a.getTimestamp().compareTo(b.getTimestamp()));
        return queries;
    }
}
