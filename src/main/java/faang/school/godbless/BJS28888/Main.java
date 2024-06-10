package faang.school.godbless.BJS28888;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataBase dataBase = new DataBase();
        dataBase.addElement(1, "information of Data with id 1");
        dataBase.addElement(2, "information of Data with id 2");
        dataBase.addElement(3, "information of Data with id 3");
        dataBase.addElement(4, "information of Data with id 4");
        dataBase.addElement(5, "information of Data with id 5");
        dataBase.addElement(6, "information of Data with id 6");

        dataBase.printCache();

        dataBase.getElement(6);
        Thread.sleep(1000);
        dataBase.getElement(5);
        Thread.sleep(1000);
        dataBase.getElement(4);
        Thread.sleep(1000);
        dataBase.getElement(3);
        Thread.sleep(1000);
        dataBase.getElement(2);
        dataBase.printCache();
        Thread.sleep(1000);
        dataBase.getElement(1);
        Thread.sleep(1000);
        dataBase.printCache();
    }
}
