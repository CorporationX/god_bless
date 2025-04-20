package school.faang.bjs2_72662;

import lombok.Getter;

@Getter
class Config {
    private final int threadsCount = 5;
    private final int toatlMessages = 1000;
    private final int batchSize = toatlMessages / threadsCount;
}
