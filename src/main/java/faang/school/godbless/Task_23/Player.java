package faang.school.godbless.Task_23;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Player {
    final String lock;
    String isPlaying;

    void previous() {
        synchronized (lock) {
            System.out.println(isPlaying);
        }
    }

    void skip() {
        synchronized (lock) {
            System.out.println(isPlaying);
        }
    }

    void pause() {
        synchronized (lock) {
            System.out.println(isPlaying);
        }
    }

    void play() {
        synchronized (lock) {
            System.out.println(isPlaying);
        }
    }
}
