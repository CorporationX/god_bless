package faang.school.godbless.lruCache;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;


@lombok.Data
@AllArgsConstructor
public class CacheServiceImpl implements CacheService {

    private final CacheRepository cacheRepository;

    @Override
    public Data create(Integer id, String value) {
        if (id == null || value == null) {
            return null;
        }

        return cacheRepository.create(Data.builder()
                .id(id)
                .value(value)
                .timestamp(LocalDateTime.now())
                .build());
    }

    @Override
    public Data get(Integer id) {
        if (id == null) {
            return null;
        }

        return cacheRepository.get(id);
    }
}
