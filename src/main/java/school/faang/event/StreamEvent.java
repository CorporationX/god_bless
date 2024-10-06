package school.faang.event;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StreamEvent {

  private int id;
  private String eventType;
  private String data;

  public StreamEvent(int id, String eventType, String data) {
    this.id = id;
    this.eventType = eventType;
    this.data = data;
  }

  @Override
  public String toString() {
    return "StreamEvent{"
        + "id=" + id
        + ", eventType='" + eventType + '\''
        + ", data='" + data + '\'' + '}';
  }
}
