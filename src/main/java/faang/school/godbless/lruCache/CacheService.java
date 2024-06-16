package faang.school.godbless.lruCache;

import java.rmi.ServerException;

public interface CacheService {

    Data create(Integer id, String value) throws ServerException;

    Data get(Integer id);
}
