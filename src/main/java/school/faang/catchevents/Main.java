package school.faang.catchevents;

import java.util.*;

public class Main {
    static Map<Integer, StreamEvent> firstHashMap = new HashMap<>();
    static Map<String, List<StreamEvent>> secondHashMap = new HashMap<>();

    public static void main(String[] args) {
        boolean stop = false;
        int chosenOption;

        String[] options = {"\n1.Add StreamEvent"
                , "2.Search by ID"
                , "3.Search by EventType"
                , "4.Delete by ID"
                , "5.Print all Events"
                , "6.Quit"};

        for (String option : options) {
            System.out.println(option);
        }

        while (!stop) {
            Scanner scan = new Scanner(System.in);

            System.out.print("\nChoose one of the options: ");
            if (scan.hasNextInt()) {

                chosenOption = scan.nextInt();

                switch (chosenOption) {
                    case 1:
                        System.out.println("\nChosen add StreamEvent");
                        System.out.print("Indicate ID event: ");
                        int id = scan.nextInt();
                        System.out.print("Indicate EventType: ");
                        String eventType = scan.next();
                        System.out.print("Indicate Data: ");
                        String data = scan.next();

                        addNewEvent(id, eventType, data);
                        break;
                    case 2:
                        System.out.println("\nChosen search by ID");
                        System.out.print("Indicate ID event: ");
                        int searchId = scan.nextInt();

                        StreamEvent resultById = searchById(searchId);
                        if (resultById != null) {
                            System.out.println("\nObject found");
                        } else {
                            System.out.println("\nNothing found");
                        }
                        break;
                    case 3:
                        System.out.println("\nChosen search by EventType");
                        System.out.print("Indicate EventType: ");
                        String searchByType = scan.next();

                        List<StreamEvent> resultByType = searchByTypeOfEvent(searchByType);
                        if (resultByType.size() > 0) {
                            System.out.println("\nFound " + resultByType.size() + " entries in List");
                        } else {
                            System.out.println("\nNothing found");
                        }
                        break;
                    case 4:
                        System.out.println("\nChosen delete by ID");
                        System.out.print("Indicate ID event: ");
                        int deleteById = scan.nextInt();

                        deleteById(deleteById);
                        break;
                    case 5:
                        System.out.println("\nChosen print all Events");
                        printAll();
                        break;
                    case 6:
                        System.out.println("\nChosen Quit - Bye!");
                        stop = true;
                        break;
                    default:
                        System.out.println("\nInvalid choose");
                        break;
                }
            }

        }
        System.out.println();
    }


    public static void addNewEvent(int id, String eventType, String data) {
        StreamEvent eventInstance = new StreamEvent(id, eventType, data);
        StreamEvent result = firstHashMap.get(id);
        if (result == null) {
            firstHashMap.put(id, eventInstance);
            List<StreamEvent> addToList = secondHashMap.computeIfAbsent(eventType, x -> new ArrayList<StreamEvent>());
            addToList.add(eventInstance);
        }
    }

    public static StreamEvent searchById(int id) {
        StreamEvent result = firstHashMap.get(id);
        return result;
    }

    public static List<StreamEvent> searchByTypeOfEvent(String eventType) {
        List<StreamEvent> result = secondHashMap.computeIfAbsent(eventType, x -> new ArrayList<StreamEvent>());
        return result;
    }

    public static void deleteById(int id) {
        StreamEvent objectToDelete = searchById(id);
        if (objectToDelete != null) {
            firstHashMap.remove(id);

            List<StreamEvent> getList = secondHashMap.get(objectToDelete.getEventType());
            getList.remove(objectToDelete);
        } else {
            System.out.println("\nNothing to delete");
        }
    }

    public static void printAll() {
        System.out.println("First HashMap:");
        for (Map.Entry<Integer, StreamEvent> entryFirst : firstHashMap.entrySet()) {
            StreamEvent objectOneToPrint = entryFirst.getValue();
            System.out.println("ID " + entryFirst.getKey() + ", " + objectOneToPrint);
        }
        System.out.println();
        System.out.println("Second HashMap:");
        for (Map.Entry<String, List<StreamEvent>> entrySecond : secondHashMap.entrySet()) {
            List<StreamEvent> objectTwoToPrint = entrySecond.getValue();
            for (StreamEvent instance : objectTwoToPrint) {
                System.out.println("EventType " + entrySecond.getKey() + ", " + instance);
            }
        }


    }
}



