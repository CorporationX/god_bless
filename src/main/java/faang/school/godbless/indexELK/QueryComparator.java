package faang.school.godbless.indexELK;

import java.util.Comparator;

public class QueryComparator implements Comparator<Query> {
    public int compare(Query query1, Query query2) {
        return query1.getTimestamp().compareTo(query2.getTimestamp());
    }
}