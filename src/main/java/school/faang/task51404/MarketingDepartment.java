package school.faang.task51404;


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
        log.info("Маркетинг читает дизайн ресурсы .");
        List<String> designFiles = designResources.getFiles();

        log.info("Маркетинг добавляет файл в свои ресурсы ...");
        marketingResources.addFile("Marketing Analysis ");
    }
}
