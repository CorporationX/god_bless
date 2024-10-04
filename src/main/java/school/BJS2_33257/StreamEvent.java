package school.BJS2_33257;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StreamEvent {

    private int id;
    private String type;
    private String date;

    @Override
    public String toString() {
        return "StreamEvent{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}