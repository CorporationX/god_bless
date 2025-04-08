package school.faang.bjs248737;

public class Main {
    public static void main(String[] args) {
        String[] choresList = {
                "Wash dishes",
                "Sweep floor",
                "Cook dinner",
                "Take out trash",
                "Water plants",
                "Clean windows",
                "Mow the lawn",
                "Do laundry",
                "Iron clothes",
                "Vacuum the house",
                "Dust furniture",
                "Clean the bathroom",
                "Organize the garage",
                "Wash the car",
                "Feed the pets",
                "Grocery shopping",
                "Prepare lunch",
                "Clean the fridge",
                "Take care of the garden",
                "Pay bills",
                "Sort the mail",
                "Clean the attic",
                "Polish shoes",
                "Change bed sheets",
                "Clean the oven",
                "Wipe down counter-tops",
                "Clean the microwave",
                "Empty trash bins",
                "Clean the fireplace",
                "Organize bookshelves"
        };

        WeasleyFamily weasleyFamilyTasks = new WeasleyFamily(choresList);
        weasleyFamilyTasks.executorChores();
    }
}