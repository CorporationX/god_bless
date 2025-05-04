package school.faang.deadlock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        log.info("Работает маркетинговый департамент");
        log.info("Чтение дизайн ресурсов");
        List<String> files = designResources.readFile();
        log.info("Запись в ресурсы маркетинга");
        files.forEach(marketingResources::writeFile);
    }
}
