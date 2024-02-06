package WWF;

import lombok.Getter;

@Getter
public class Donation {
    //maxId нужен чтобы у каждого Donation был свой уникальный id
    private static int maxId;
    private final int id;
    private final int volume;
    private static final Object lock = new Object();

    public Donation(int volume) {
        //Лок нужен чтобы потоки по очереди меняли общее значение maxId
        // при одновременном создании нескольких объектов Donation
        synchronized (lock) {
            this.volume = volume;
            this.id = maxId;
            maxId++;
        }
    }

    public static int getMaxId() {
        return maxId;
    }
}
