package faang.school.godbless.lrucache;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class DataRepositoryCustom implements DataRepository {

    private final DataSource<Data> dataSource;

    @Override
    public Data save(Data newData) {
        return dataSource.put(newData);
    }

    @Override
    public Optional<Data> findById(Integer id) {
        return Optional.ofNullable(dataSource.get(id));
    }
}
