package school.faang.bjs247660;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class PigThread extends Thread {
    private final String pigName;
    private final String material;
}