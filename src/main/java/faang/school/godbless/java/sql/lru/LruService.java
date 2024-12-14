package faang.school.godbless.java.sql.lru;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
public class LruService {
    private Map<Integer, Data> cachedData = new LinkedHashMap<>();

    public void addNewDataInCache(Data data) {
        if (this.cachedData.containsKey(data.getId())) {
            throw new IllegalArgumentException("Element with ID " + data.getId() + " already exists in the map");
        }
        this.cachedData.put(data.getId(), data);
        this.cleanOldEntriesFromCache();
    }

    public Data getDataByDataId(Data data) {
        if (this.cachedData.containsKey(data.getId())) {
            this.updateDataInCache(data);
            return this.cachedData.get(data.getId());
        }
        this.updateDataInCache(data);
        return data;
    }

    public void printCacheState() {
        System.out.println("Cache contains the following values:");
        for (Map.Entry<Integer, Data> entry: this.cachedData.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private void sortCacheEntriesByDate() {
        // The solution was found here https://stackoverflow.com/questions/61942671/sorting-mapstring-string-by-datevalue-using-stream-java
        Map<Integer, Data> sortedData = cachedData.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Data::getTimestamp)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (d1, d2) -> d2,
                        LinkedHashMap::new
                ));
        this.cachedData.clear();
        this.cachedData = sortedData;
    }

    private void cleanOldEntriesFromCache() {
        this.sortCacheEntriesByDate();
        Data data;
        Set<Map.Entry<Integer, Data>> entries = this.cachedData.entrySet();
        while (this.cachedData.size() > Constants.CACHE_SIZE) {
            data = entries.iterator().next().getValue();
            cachedData.remove(data.getId());
        }
    }

    private void updateDataInCache(Data data) {
        cachedData.computeIfAbsent(data.getId(), k -> data).setTimestamp(LocalDateTime.now());
        this.cleanOldEntriesFromCache();
    }
}
