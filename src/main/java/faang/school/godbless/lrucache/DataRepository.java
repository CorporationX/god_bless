package faang.school.godbless.lrucache;

import java.util.Optional;

public interface DataRepository {

    Data save(Data newData);

    Optional<Data> findById(Integer id);
}
