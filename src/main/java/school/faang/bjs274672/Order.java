package school.faang.bjs274672;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
    private final int id;
    private Status status = Status.NEW;

    public synchronized void setStatus(Status status) {
        this.status = status;
        log.info("Order [{}] have new status: {}", id, status);
    }
}
