package faang.school.godbless.BJS2_25545;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Participant {
    private String name;

    public void joinConference(Conference conference) {
        conference.join(this.name);
    }
}