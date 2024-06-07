package faang.school.godbless.lrucache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    private LRUCache lruCache;
    private DataSource dataSource;
    private DataRepository repository;
    private Clock clock;
    private AtomicInteger count;

    @BeforeEach
    void prepare() {
        this.count = new AtomicInteger(0);
        this.lruCache = new LRUCache();
        this.dataSource = new DataSource();
        this.clock = Clock.fixed(Clock.systemDefaultZone().instant(), Clock.systemUTC().getZone());
        this.repository = new Main(new DataRepositoryCustom(dataSource), lruCache, clock);
    }

    @Test
    void save() {
        Data data1 = getData("data1");
        Data data2 = getData("data2");

        this.repository.save(data1);
        Data savedRepositoryActualData = this.repository.save(data2);

        assertNotNull(savedRepositoryActualData.getId());
        Optional<Data> maybeSavedCachedActualData = this.lruCache.get(savedRepositoryActualData.getId());
        assertTrue(maybeSavedCachedActualData.isPresent());
        maybeSavedCachedActualData.ifPresent(savedCachedActualData -> assertThat(savedCachedActualData).isSameAs(savedRepositoryActualData));
    }

    @Test
    void findById() {
        Data data1 = getData("data1");
        Data data2 = getData("data2");
        Data data3 = getData("data3");
        Data data4 = getData("data4");
        Data savedRepositoryActualData = this.repository.save(data1);
        this.repository.save(data2);
        this.repository.save(data3);
        this.repository.save(data4);

        Optional<Data> maybeFoundDate = repository.findById(savedRepositoryActualData.getId());

        maybeFoundDate.ifPresent(foundDate -> assertThat(foundDate).isEqualTo(savedRepositoryActualData));
    }

    @Test
    void checkUpdateCacheAfterSavingWithExceedingCacheSize() {
        final int lruCacheFullSize = 4;
        final int dataSourceSize = 5;
        Data data1 = getData("data1");
        Data data2 = getData("data2");
        Data data3 = getData("data3");
        Data data4 = getData("data4");
        Data data5 = getData("data5");

        this.repository.save(data1);
        this.repository.save(data2);
        this.repository.save(data3);
        this.repository.save(data4);
        this.repository.save(data5);

        assertThat(this.lruCache.size()).isEqualTo(lruCacheFullSize);
        assertThat(this.dataSource.size()).isEqualTo(dataSourceSize);
        Optional<Data> maybeSavedCachedActualData1 = this.lruCache.get(data1.getId());
        assertFalse(maybeSavedCachedActualData1.isPresent());
        Optional<Data> maybeSavedCachedActualData5 = this.lruCache.get(data5.getId());
        assertTrue(maybeSavedCachedActualData5.isPresent());
    }

    @Test
    void checkUpdateCacheAfterDataUsed() {
        Data data1 = getData("data1");
        Data data2 = getData("data2");
        Data data3 = getData("data3");
        Data data4 = getData("data4");
        Data data5 = getData("data5");
        this.repository.save(data1);
        this.repository.save(data2);
        this.repository.save(data3);
        this.repository.save(data4);
        this.repository.save(data5);

        this.repository.findById(data1.getId());

        Optional<Data> maybeSavedCachedActualData1 = this.lruCache.get(data1.getId());
        assertTrue(maybeSavedCachedActualData1.isPresent());
        Optional<Data> maybeSavedCachedActualData2 = this.lruCache.get(data2.getId());
        assertFalse(maybeSavedCachedActualData2.isPresent());
    }

    @Test
    void checkUpdateTimestampAfterDataUsed() {
        Data data1 = getData("data1");
        Data data2 = getData("data2");
        Data data3 = getData("data3");
        this.repository.save(data1);
        this.repository.save(data2);
        this.repository.save(data3);

        this.repository.findById(data1.getId());

        assertThat(data1.getTimestamp()).isAfter(data3.getTimestamp());
    }

    private Data getData(String value) {
        return new Data(value, clock.instant().minus(Duration.ofDays(30)).plus(Duration.ofDays(count.incrementAndGet())));
    }
}