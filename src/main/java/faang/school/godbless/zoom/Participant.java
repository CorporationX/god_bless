package faang.school.godbless.zoom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Participant {
    private String name;

    public void joinConference(Conference conference) {
        conference.joinConference(this);
    }
}

