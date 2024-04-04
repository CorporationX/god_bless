package faang.school.godbless.college;

public class Main {
    public static void main(String[] args) {
        StudentJournal journal = new StudentJournal();
        Student student1 = new Student("Ivanov", "Physics", 1);
        Student student2 = new Student("Petrov", "Physics", 1);
        Student student3 = new Student("Musc", "Physics", 5);
        Student student4 = new Student("Bezos", "IT", 5);
        Student student5 = new Student("Gates", "IT", 5);

        journal.addNewStudent(student1);
        journal.addNewStudent(student2);
        journal.addNewStudent(student3);
        journal.addNewStudent(student4);
        journal.addNewStudent(student5);

        journal.displayAllByGroups();

        journal.deleteByAttributes("Musc", "Physics", 5);

        journal.displayAllByGroups();

        journal.findByGroup("Physics", 1);
    }
}
