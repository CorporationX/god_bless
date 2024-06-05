package faang.school.godbless.elk;

import java.util.Date;

public record Query(Integer id, String content, Date timestamp) implements Comparable<Query> {

  @Override
  public int compareTo(Query query) {
    return this.timestamp.compareTo(query.timestamp);
  }
}
