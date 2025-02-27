package school.faang.sprint4.bjs2_62893;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        log.info("Маркетинг читает ресурсы Дизайна.");
        List<String> designFiles = designResources.readFiles();
        log.info("Маркетинг записывает файлы в свои ресурсы.");
        marketingResources.writeFile("Маркетинг_файл");
    }
}
