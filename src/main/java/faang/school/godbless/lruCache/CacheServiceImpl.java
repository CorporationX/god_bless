package faang.school.godbless.lruCache;

import lombok.AllArgsConstructor;

import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.Optional;


@lombok.Data
@AllArgsConstructor
public class CacheServiceImpl implements CacheService {

    private final CacheRepository cacheRepository;

    @Override
    public Data create(Integer id, String value) throws ServerException {
        if (!isValidId(id) || value == null) {
            return null;
        }

        Optional<Data> createdData = cacheRepository.create(Data.builder()
                .id(id)
                .value(value)
                .timestamp(LocalDateTime.now())
                .build());

        return createdData.orElseThrow(() -> new ServerException("Can't create"));
    }

    @Override
    public Data get(Integer id) {
        if (!isValidId(id)) {
            return null;
        }

        return cacheRepository.get(id);
    }

    public boolean isValidId(Integer id) {
        return id != null;
    }
}
