package faang.school.godbless.MiniZoom;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Participant {
    private String name;
    public void joinConference(Conference conference){
        conference.startStreaming(this);
    }
}
