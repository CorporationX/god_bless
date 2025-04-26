package school.faang.microsoft;

import lombok.Getter;

@Getter
public class MailConfig {
    private final int threadCount = 5;
    private final int totalMessages = 1000;
    private final int batchSize = totalMessages / threadCount;
}
