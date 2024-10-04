package school.faang.catchingEvents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StreamEvent {
  private int id;
  private String eventType;
  private String data;

}
