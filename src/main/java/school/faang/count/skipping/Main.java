package school.faang.count.skipping;

public class Main {
    public static void main(String[] args) {
        var student1 = new Student("Filip", new Course("Ecology", 2));
        var student2 = new Student("Egor", new Course("Economic", 3));
        var student4 = new Student("Kolya", new Course("Economic", 3));
        var student3 = new Student("Vlad", new Course("Mathematics", 1));
        var student5 = new Student("Elon", new Course("Mathematics", 1));

        AccountingSystem accountingSystem = new AccountingSystem();

        //добавление & печать
        accountingSystem.add(student1);
        accountingSystem.add(student2);
        accountingSystem.add(student3);
        accountingSystem.add(student4);
        accountingSystem.add(student5);
        System.out.println("Добавленные студенты");
        accountingSystem.print();

        //поиск
        System.out.println("Стьуденты 3 курса факультета экономики");
        System.out.println(accountingSystem.get(new Course("Economic", 3)));

        //удаление
        System.out.println("Удалили первого студента");
        accountingSystem.remove(student1.getName());
        accountingSystem.print();
    }
}
