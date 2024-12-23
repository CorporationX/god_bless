package school.faang.bjs249480;

import lombok.Getter;

@Getter
public class View {
    private final Object lock = new Object();
    private Integer views = 0;

    public void increaseViews() {
        synchronized (lock) {
            views++;
        }
    }
}
