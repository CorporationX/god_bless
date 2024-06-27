package faang.school.godbless.multithreading.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private final Integer id;
    private boolean isProcessed;
    private final Integer orderComplexity;
}
