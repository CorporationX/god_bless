package faang.school.godbless.Zoom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Data
@AllArgsConstructor
@Slf4j
public class Participant {
    private final String id;
    private final String name;

    public Participant(@NonNull String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public void joinConference() {
        log.info("{} joined the conference", name);
    }
}
