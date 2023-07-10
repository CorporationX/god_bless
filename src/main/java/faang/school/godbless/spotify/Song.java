package faang.school.godbless.spotify;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Song {
    private final String name;
    private final String artist;
    private Song next;
    private Song previous;
}
