package school.faang.sprint4.bjs2_62893;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class DesignDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        synchronized (marketingResources) {
            log.info("Дизайн читает ресуры Маркетинга.");
            List<String> marketingFiles = marketingResources.readFiles();
            synchronized (designResources) {
                log.info("Дизайн записывает файлы в свои ресурсы.");
                designResources.writeFile("Дизайн_файл");
            }
        }
    }
}
