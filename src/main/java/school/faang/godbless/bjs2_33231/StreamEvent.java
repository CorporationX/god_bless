package school.faang.godbless.bjs2_33231;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
@AllArgsConstructor
public class StreamEvent {

  private int id;
  private String eventType;
  private String data;
}
