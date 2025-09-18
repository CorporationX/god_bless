package school.faang.multithreading_parallelism_thread.bjs2_91292;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PigThread extends Thread {
    private final String pigName;
    private final String material;
}
