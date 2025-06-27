package school.faang.bjs2_81786;

import java.util.concurrent.atomic.AtomicLong;

public class GeneratorId {
    private final AtomicLong id;

    public GeneratorId(long id) {
        this.id = new AtomicLong(id);
    }

    public long nextId() {
        return id.incrementAndGet();
    }

}
