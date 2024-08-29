package faang.school.godbless.sprint4.amazon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Order {
    private final long id;
    private String status = "Новый";
}
