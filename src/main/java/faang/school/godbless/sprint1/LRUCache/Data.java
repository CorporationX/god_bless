package faang.school.godbless.sprint1.LRUCache;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@Getter
public class Data {
  private int id;
  private String value;
  @Setter
  private long timestamp;

  private String formattedDateTime() {
    Date date = new Date(timestamp);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    return sdf.format(date);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Data.class.getSimpleName() + "[", "]")
        .add("id = " + id)
        .add("value = '" + value + "'")
        .add("dateTime = " + formattedDateTime())
        .toString();
  }
}
