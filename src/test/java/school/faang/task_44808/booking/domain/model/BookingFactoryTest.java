package school.faang.task_44808.booking.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("BookingFactoryTest: Tests for getNextId method")
class BookingFactoryTest {

    @Test
    @DisplayName("getNextId: should return initial id when first called")
    void getNextId_shouldReturnInitialIdWhenFirstCalled() {
        // Arrange
        int initialCounter = 100;
        BookingFactory bookingFactory = new BookingFactory(null, initialCounter);

        // Act
        int nextId = bookingFactory.getNextId();

        // Assert
        assertEquals(100, nextId, "The first ID returned should match the initial counter value.");
    }

    @Test
    @DisplayName("getNextId: should increment id correctly on multiple calls")
    void getNextId_shouldIncrementIdCorrectlyOnMultipleCalls() {
        // Arrange
        int initialCounter = 1;
        BookingFactory bookingFactory = new BookingFactory(null, initialCounter);

        // Act
        int firstId = bookingFactory.getNextId();
        int secondId = bookingFactory.getNextId();
        int thirdId = bookingFactory.getNextId();

        // Assert
        assertEquals(1, firstId, "The first ID returned should match the initial counter value.");
        assertEquals(2, secondId, "The second ID should increment correctly.");
        assertEquals(3, thirdId, "The third ID should increment correctly.");
    }

    @Test
    @DisplayName("getNextId: should handle large ranges of ids correctly")
    void getNextId_shouldHandleLargeRangesOfIdsCorrectly() {
        // Arrange
        int initialCounter = Integer.MAX_VALUE - 2;
        BookingFactory bookingFactory = new BookingFactory(null, initialCounter);

        // Act
        int firstId = bookingFactory.getNextId();
        int secondId = bookingFactory.getNextId();
        int thirdId = bookingFactory.getNextId();

        // Assert
        assertEquals(Integer.MAX_VALUE - 2, firstId, "First ID should match the initial counter value.");
        assertEquals(Integer.MAX_VALUE - 1, secondId, "Second ID should be correctly incremented.");
        assertEquals(Integer.MAX_VALUE, thirdId,
                "Third ID should be correctly incremented to reach max integer value.");
    }

    @Test
    @DisplayName("getNextId: should ensure thread safety when accessed concurrently")
    void getNextId_shouldEnsureThreadSafetyWhenAccessedConcurrently() throws InterruptedException {
        // Arrange
        int initialCounter = 1;
        BookingFactory bookingFactory = new BookingFactory(null, initialCounter);
        AtomicInteger failureCount = new AtomicInteger(0);
        int threads = 10;

        // Act
        Thread[] threadPool = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            threadPool[i] = new Thread(() -> {
                int id = bookingFactory.getNextId();
                if (id <= 0) {
                    failureCount.incrementAndGet();
                }
            });
        }

        for (Thread thread : threadPool) {
            thread.start();
        }

        for (Thread thread : threadPool) {
            thread.join();
        }

        // Assert
        assertEquals(0, failureCount.get(), "All IDs should be unique and incremented correctly without failure.");
        assertTrue(bookingFactory.getNextId() >= threads + initialCounter,
                "IDs should increment correctly up to at least number of threads + initial counter.");
    }
}