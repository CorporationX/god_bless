package school.faang.sprint.fourth.amazon;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int id;
    @NonNull
    private String status;

    public Order(int id, @NonNull String status) {
        validate(id, status);
        this.id = id;
        this.status = status;
    }

    private void validate(int id, @NonNull String status) {
        if (id < 0) {
            throw new IllegalArgumentException("id must be a positive integer");
        }
        if (status.isBlank()) {
            throw new IllegalArgumentException("status cannot be blank");
        }
    }
}
