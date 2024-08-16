package faang.school.godbless.java.sql.lru;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LruServiceTest {
    private LruService lruService;
    private Data testData1;
    private Data testData2;
    private Data testData3;
    private Data testData4;
    private Data testData5;
    private Data testData6;
    private Data testData7;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        this.lruService = new LruService();
        this.testData1 = new Data(1, "Dog", "2024-08-11T10:55:30");
        this.testData2 = new Data(2, "Cat", "2024-08-14T13:55:30");
        this.testData3 = new Data(3, "Monkey", "2024-08-14T11:55:30");
        this.testData4 = new Data(4, "Crocodile", "2024-05-29T11:55:30");
        this.testData5 = new Data(5, "Car", "2024-08-13T11:55:30");
        this.testData6 = new Data(6, "Pencil", "2024-12-14T11:55:30");
        this.testData7 = new Data(7, "City", "2024-08-01T11:55:30");

        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testAddNewDataInCache_addOneElementToMap() {
        lruService.addNewDataInCache(this.testData1);

        assertEquals(this.testData1.getId(), this.lruService.getCachedData().size());
        assertEquals(testData1.getValue(), this.lruService.getCachedData().get(this.testData1.getId()).getValue());
        assertTrue(lruService.getCachedData().containsKey(this.testData1.getId()));
    }

    @Test
    void testAddNewDataInCache_addTheSameElementToCacheAndCatchException() {
        lruService.addNewDataInCache(this.testData1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lruService.addNewDataInCache(this.testData1);
        });

        String expectedMessage = "Element with ID 1 already exists in the map";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testAddNewDataInCache_checkHowCacheRemoveOldElements() {
        lruService.addNewDataInCache(this.testData1);
        lruService.addNewDataInCache(this.testData2);
        lruService.addNewDataInCache(this.testData3);
        lruService.addNewDataInCache(this.testData4);
        lruService.addNewDataInCache(this.testData5);
        lruService.addNewDataInCache(this.testData6);
        lruService.addNewDataInCache(this.testData7);

        assertEquals(Constants.CACHE_SIZE, this.lruService.getCachedData().size());
    }

    @Test
    void testGetDataByDataId_getExistingValueWithUpdatedDate() {
        lruService.addNewDataInCache(this.testData1);
        lruService.addNewDataInCache(this.testData2);
        lruService.addNewDataInCache(this.testData3);
        lruService.addNewDataInCache(this.testData4);
        lruService.addNewDataInCache(this.testData5);

        LocalDateTime oldTimestamp = this.testData2.getTimestamp();
        Data data = lruService.getDataByDataId(this.testData2);

        assertTrue(data.getTimestamp().isAfter(oldTimestamp));
        assertTrue(lruService.getCachedData().containsKey(data.getId()));
        assertEquals(Constants.CACHE_SIZE, this.lruService.getCachedData().size());
    }

    @Test
    void testGetDataByDataId_getNonExistingValueWithAddNewElementAndUpdateDate() {
        lruService.addNewDataInCache(this.testData1);
        lruService.addNewDataInCache(this.testData2);
        lruService.addNewDataInCache(this.testData3);
        lruService.addNewDataInCache(this.testData4);
        lruService.addNewDataInCache(this.testData5);

        LocalDateTime oldTimestamp = this.testData7.getTimestamp();
        Data data = lruService.getDataByDataId(this.testData7);

        assertTrue(data.getTimestamp().isAfter(oldTimestamp));
        assertTrue(lruService.getCachedData().containsKey(data.getId()));
        assertEquals(Constants.CACHE_SIZE, this.lruService.getCachedData().size());
    }

    @Test
    void testPrintCacheState() {
        // The solution to test sout found here https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
        lruService.addNewDataInCache(this.testData1);
        lruService.addNewDataInCache(this.testData2);

        lruService.printCacheState();

        String output = this.outContent.toString();

        String expectedOutput = "Cache contains the following values:\n" +
                this.testData1 + "\n" +
                this.testData2 + "\n";
        assertEquals(expectedOutput, output);
    }

    @AfterEach
    void tearDown() {
        System.setOut(this.originalOut);
    }

}
