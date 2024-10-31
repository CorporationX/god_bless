package school.faang.workSuspended.Deadlock;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MarketingResources {
    private final List<String> marketingFiles;

    public synchronized void addFile(String file) {
        marketingFiles.add(file);
    }

    public synchronized List<String> getMarketingFiles() {
        return marketingFiles;
    }
}
