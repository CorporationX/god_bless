package school.faang.theworkstands;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DesignDepartment extends Department {

    public DesignDepartment(MarketingResources marketingResources, DesignResources designResources) {
        super(marketingResources, designResources);
    }

    @Override
    public void run() {
        log.info("Дизайнеры читают ресурсы маркетинга");
        List<String> marketingFiles = marketingResources.getFileNames();
        synchronized (designResources) {
            log.info("Дизайнеры добавляют файл в свои ресурсы");
            designResources.addFile("Design Analysis");
        }
    }
}
