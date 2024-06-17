package faang.school.godbless.lruCache;

import lombok.AllArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@lombok.Data
@AllArgsConstructor
public class CacheRepositoryImpl implements CacheRepository {

    private final Map<Integer, Data> CACHED_DATA;
    private final ArrayDeque<Integer> ID_DATA;

    private final List<Data> MAIN_REPOSITORY;

    private final Integer CACHE_SIZE = 3;

    public CacheRepositoryImpl() {
        CACHED_DATA = new HashMap<>();
        ID_DATA = new ArrayDeque<>();
        MAIN_REPOSITORY = new ArrayList<>();
    }

    @Override
    public Optional<Data> create(Data data) {
        if (containsDataInCache(data.getId())) {
            ID_DATA.remove(data.getId());
            ID_DATA.addFirst(data.getId());

            CACHED_DATA.get(data.getId()).setTimestamp(data.getTimestamp());
        } else {
            if (ID_DATA.size() == CACHE_SIZE) {
                Integer lastId = ID_DATA.getLast();

                ID_DATA.removeLast();
                CACHED_DATA.remove(lastId);
            }

            CACHED_DATA.put(data.getId(), data);
            ID_DATA.addFirst(data.getId());
            MAIN_REPOSITORY.add(data);
        }

        return Optional.of(data);
    }

    @Override
    public Data get(Integer id) {
        Data data;

        if (containsDataInCache(id)) {
            ID_DATA.remove(id);
            ID_DATA.addFirst(id);

            data = CACHED_DATA.get(id);
            data.setTimestamp(LocalDateTime.now());

        } else {
            Optional<Data> foundedData = MAIN_REPOSITORY.stream()
                    .filter(d -> d.getId().equals(id))
                    .findFirst();

            if (foundedData.isEmpty()) {
                return null;
            }

            data = foundedData.get();
            data.setTimestamp(LocalDateTime.now());

            if (ID_DATA.size() == CACHE_SIZE) {
                Integer lastId = ID_DATA.getLast();

                ID_DATA.removeLast();
                CACHED_DATA.remove(lastId);
            }

            ID_DATA.addFirst(data.getId());
            CACHED_DATA.put(data.getId(), data);
        }

        return data;
    }

    private boolean containsDataInCache(Integer id) {
        return CACHED_DATA.containsKey(id);
    }
}
