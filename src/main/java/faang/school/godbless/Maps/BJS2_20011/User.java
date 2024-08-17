package faang.school.godbless.Maps.BJS2_20011;

import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@EqualsAndHashCode
public class User {
    private final int id;
    private String name;
    @EqualsAndHashCode.Exclude
    private List<Query> queries;

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

    public void printQueries() {
        for (Query query : queries) {
            System.out.println(query.getId() + ":" + query.getContent());
        }
    }
}
