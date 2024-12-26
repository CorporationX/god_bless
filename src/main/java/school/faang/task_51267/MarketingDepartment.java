package school.faang.task_51267;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@RequiredArgsConstructor
public class MarketingDepartment {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public Runnable startTask = new Runnable() {
        @SneakyThrows
        @Override
        public void run() {
            List<String> files = designResources.getFiles();
            Thread.sleep(1000);
            synchronized (marketingResources) {
                marketingResources.getFiles().addAll(files);
            }
        }
    };
}
