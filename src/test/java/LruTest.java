import faang.school.godbless.LRU.Data;
import faang.school.godbless.LRU.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LruTest {
    private Main main;

    @BeforeEach
    public void init() {
        main = new Main();
    }

    @Test
    public void addDataTest() {
        for (Long i = 0L; i < 100L; i++) {
            Data data = new Data(i,i);
            main.addData(data);

        }
    }


}
