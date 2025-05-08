package school.faang.deadlock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class DesignDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        log.info("Работает дизайн департамент");
        log.info("Чтение маркетинговых ресурсов");
        List<String> files = marketingResources.readFile();
        log.info("Запись в ресурсы дизайна");
        files.forEach(designResources::writeFile);
    }
}
