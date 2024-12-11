package school.faang.moduleone.task_43514;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static school.faang.moduleone.task_43514.TimeSlot.TIME_SLOT_12_16;
import static school.faang.moduleone.task_43514.TimeSlot.TIME_SLOT_16_20;

class BookingSystemTest {
    private BookingObserver spyObserver;
    private BookingSystem bookingSystem;
    private Room room;

    @BeforeEach
    void beforeEach() {
        BookingObserver observer = new BookingObserver() {
            @Override
            public void update(Booking booking, String status) {
                System.out.printf("Status is: %s, booking is: %s", status, booking.toString());
            }
        };
        spyObserver = Mockito.spy(observer);

        bookingSystem = new BookingSystem(
                new HashSet<>(),
                new ArrayList<>(),
                new BookingNotifier(new ArrayList<>(Arrays.asList(spyObserver))), 0);

        room = new Room("type1", Set.of("fridge", "TV", "air-conditioner"));
        bookingSystem.addRoom(room);
    }

    @Test
    void addRoom() {
        //given
        Room newRoom = new Room("type2", Set.of("fridge"));

        //when
        int roomId = bookingSystem.addRoom(newRoom);

        //then
        assertEquals(2, bookingSystem.getCountOfRegisteredRooms());
        assertTrue(roomId > 0);
    }

    @Test
    void removeRoom() {
        //when
        boolean resultOfDeletion = bookingSystem.removeRoom(room.getRoomId());
        boolean resultOfRepeatedDeletion = bookingSystem.removeRoom(room.getRoomId());

        //then
        assertTrue(resultOfDeletion);
        assertFalse(resultOfRepeatedDeletion);
    }

    @Test
    void bookRoom() {
        //when
        final int roomId = room.getRoomId();
        final int successBookingId =
                bookingSystem.bookRoom(roomId, LocalDate.now().toString(), TIME_SLOT_12_16.getLabel());
        final int successBookingIdNextTimeSlot =
                bookingSystem.bookRoom(roomId, LocalDate.now().toString(), TIME_SLOT_16_20.getLabel());

        //then
        assertTrue(successBookingId > 0);
        assertTrue(successBookingIdNextTimeSlot > 0);
        assertThrows(IllegalArgumentException.class,
                () -> bookingSystem.bookRoom(roomId + 1, LocalDate.now().toString(), TIME_SLOT_12_16.getLabel()));
        assertThrows(IllegalArgumentException.class,
                () -> bookingSystem.bookRoom(roomId, LocalDate.now().toString(), TIME_SLOT_12_16.getLabel()));
        assertEquals(2, bookingSystem.getCountOfBookings());
        Mockito.verify(spyObserver, times(2)).update(any(), any());
    }

    @Test
    void cancelBooking() {
        //given
        int roomId = room.getRoomId();
        int successBookingId = bookingSystem.bookRoom(roomId, LocalDate.now().toString(), TIME_SLOT_12_16.getLabel());

        // when
        boolean resultOfCanceling = bookingSystem.cancelBooking(successBookingId);

        //then
        assertTrue(resultOfCanceling);
        assertEquals(0, bookingSystem.getCountOfBookings());
    }

    @Test
    void findBookingsForDate() {
        //given
        bookingSystem.bookRoom(0, LocalDate.now().toString(), TIME_SLOT_12_16.getLabel());
        bookingSystem.bookRoom(0, LocalDate.now().toString(), TIME_SLOT_16_20.getLabel());

        //when
        List<Booking> bookings = bookingSystem.findBookingsForDate(LocalDate.now().toString());

        //then
        assertEquals(2, bookings.size());
    }
}