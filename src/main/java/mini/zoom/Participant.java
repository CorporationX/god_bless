package mini.zoom;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Participant {
    private final String name;

    public void joinConference(Conference conference) {
        conference.joinMember(this.name);
    }
}
