package school.faang.task_44726;

import school.faang.task_44726.observer.BookingNotifier;
import school.faang.task_44726.observer.BookingObserver;
import school.faang.task_44726.observer.Subscriber;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleInteraction {

    static BookingSystem bookingSystem = new BookingSystem();
    static BookingNotifier bookingNotifier = new BookingNotifier();

    public static void consoleInteraction() {
        bookingSystem.addMultipleRoomsForMyTask();

        BookingObserver subscriberA = Subscriber.builder()
                .name("Anatolijs")
                .build();

        BookingObserver subscriberB = Subscriber.builder()
                .name("Jurijs")
                .build();

        bookingNotifier.addObserver(subscriberA);
        bookingNotifier.addObserver(subscriberB);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------------");
            System.out.println("Welcome to the Booking System!");
            System.out.println("1. Show all rooms");
            System.out.println("2. Delete room from booking system");
            System.out.println("3. Add room into the booking system");
            System.out.println("4. Book a room");
            System.out.println("5. Cancel booking");
            System.out.println("6. Show all current booking");
            System.out.println("7. Show all available room for booking");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("List of Rooms:");
                    bookingSystem.listAllAvailableRoom();
                    break;
                case 2:
                    System.out.print("Delete room. Type roomId which you would like to delete:");
                    int roomId = scanner.nextInt();
                    bookingSystem.removeRoom(roomId);
                    break;
                case 3:
                    System.out.print("Add room. Type roomId for new room:");
                    int newRoomId = scanner.nextInt();
                    bookingSystem.addNewSingleRoom(newRoomId);
                    break;
                case 4:
                    System.out.print("Book a room. Type roomId which you would like to book:");
                    int roomIdToBook = scanner.nextInt();
                    System.out.print("Type day of the week your booking begins:");
                    String bookingDay = scanner.next().toLowerCase();
                    bookingSystem.bookRoom(roomIdToBook, bookingDay);
                    break;
                case 5:
                    System.out.print("Cancel booking. Type bookingId which you would like to cancel:");
                    String bookingId = scanner.next();
                    bookingSystem.cancelBooking(bookingId);
                    break;
                case 6:
                    System.out.print("This is the list with current booking:\n");
                    bookingSystem.listAllCurrentBooking();
                    break;
                case 7:
                    System.out.print("To see what rooms are available, type day of the week to book:");
                    String dayOfTheWeek = scanner.next();
                    System.out.print("Type, using comma, what amenities you would like to have in the room:");
                    String stringWithAmenities = scanner.next();
                    String[] words = stringWithAmenities.split(",\\s*");
                    Set<String> amenities = new HashSet<>();
                    for (String word : words) {
                        amenities.add(word);
                    }
                    bookingSystem.findAvailableRooms(dayOfTheWeek, "2d", amenities);
                    break;
                case 8:
                    System.out.println("Thank you for using the Booking System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
