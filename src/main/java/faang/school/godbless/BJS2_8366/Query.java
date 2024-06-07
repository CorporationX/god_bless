package faang.school.godbless.BJS2_8366;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Query {
  private long id;
  private String content;
  private Date timestamp;
}
