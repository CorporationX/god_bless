package faang.school.godbless.BJS2_20229;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DataServiceTest {

    private DataService dataService;

    @BeforeEach
    public void setUp() {
        Map<Integer, Data> data = new HashMap<>();

        data.put(1, new Data(1, "q", LocalDateTime.now()));
        data.put(2, new Data(2, "w", LocalDateTime.now()));

        dataService = new DataService(data);
    }

    @Test
    public void testAddData(){
        Data data = new Data(3, "e", LocalDateTime.now());
        dataService.addData(data);

        assertEquals(1, dataService.getCache().size());
        assertEquals(1, dataService.getCacheQueue().size());
        assertEquals(3, dataService.getData().size());

        data = new Data(4, "r", LocalDateTime.now());

        dataService.addData(data);
        dataService.addData(new Data(5, "t", LocalDateTime.now()));
        dataService.addData(new Data(6, "y", LocalDateTime.now()));
        dataService.addData(new Data(7, "u", LocalDateTime.now()));
        dataService.addData(new Data(8, "i", LocalDateTime.now()));

        assertEquals(5, dataService.getCache().size());
        assertEquals(5, dataService.getCacheQueue().size());
        assertNull(dataService.getCache().get(3));
        assertEquals(data, dataService.getCache().get(4));

    }

    @Test
    public void testGetData(){
        Data data = new Data(3, "e", LocalDateTime.now());
        dataService.addData(data);
        dataService.addData(new Data(5, "t", LocalDateTime.now()));
        dataService.addData(new Data(6, "y", LocalDateTime.now()));
        dataService.addData(new Data(7, "u", LocalDateTime.now()));
        dataService.addData(new Data(8, "i", LocalDateTime.now()));
        dataService.addData(new Data(9, "o", LocalDateTime.now()));

        Data savedData = dataService.getDataById(9);
        assertEquals(savedData, dataService.getDataById(9));
        assertNull(dataService.getCache().get(3));

        savedData = dataService.getDataById(3);
        assertNotNull(dataService.getCache().get(3));
        assertEquals(savedData, dataService.getCache().get(3));


        assertNull(dataService.getCache().get(5));
        dataService.printCache();

    }

}
