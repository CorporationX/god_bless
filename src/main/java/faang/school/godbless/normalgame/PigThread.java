package faang.school.godbless.normalgame;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {

    private String pigName;
    private String material;
}
