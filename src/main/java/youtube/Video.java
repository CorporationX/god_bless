package youtube;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode
public class Video {
    private final UUID id;

    public Video() {
        id = UUID.randomUUID();
    }
}
