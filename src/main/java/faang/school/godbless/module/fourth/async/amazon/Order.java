package faang.school.godbless.module.fourth.async.amazon;

import java.util.UUID;

import lombok.Data;

@Data
public class Order {
    private String id = UUID.randomUUID().toString();
    private Status status = Status.NEW;
}


