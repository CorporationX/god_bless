package school.faang.task51404;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {

        log.info("Дизайн читает маркетинговые ресурсы .");
        List<String> marketingFiles = marketingResources.getFiles();

        log.info("Дизайн добавляет файл в свои ресурсы .");
        designResources.addFile("Design Sketch");
    }
}

