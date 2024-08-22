package faang.school.godbless.BJS2_24005;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Item[][] customers = getCustomers();
        CashierThread[] cashierThreads = new CashierThread[customers.length];
        IntStream.range(0, customers.length)
                .forEach(i -> cashierThreads[i] = new CashierThread(i, customers[i]));
        Arrays.stream(cashierThreads)
                .forEach(Thread::start);
    }

    private static Item[][] getCustomers() {
        Item[][] customers = new Item[10][4];

        customers[0][0] = new Item("Laptop", 1000);
        customers[0][1] = new Item("Smartphone", 500);
        customers[0][2] = new Item("Tablet", 300);
        customers[0][3] = new Item("Headphones", 100);

        customers[1][0] = new Item("Monitor", 200);
        customers[1][1] = new Item("Keyboard", 50);
        customers[1][2] = new Item("Mouse", 25);
        customers[1][3] = new Item("Webcam", 75);

        customers[2][0] = new Item("Printer", 150);
        customers[2][1] = new Item("Scanner", 120);
        customers[2][2] = new Item("Desk Chair", 250);
        customers[2][3] = new Item("Desk Lamp", 30);

        customers[3][0] = new Item("USB Drive", 20);
        customers[3][1] = new Item("External Hard Drive", 150);
        customers[3][2] = new Item("Bluetooth Speaker", 80);
        customers[3][3] = new Item("Smartwatch", 200);

        customers[4][0] = new Item("Router", 60);
        customers[4][1] = new Item("Modem", 40);
        customers[4][2] = new Item("Surge Protector", 25);
        customers[4][3] = new Item("Cable Management", 10);

        customers[5][0] = new Item("Charger", 15);
        customers[5][1] = new Item("Docking Station", 100);
        customers[5][2] = new Item("Microphone", 50);
        customers[5][3] = new Item("Headset", 120);

        customers[6][0] = new Item("Graphics Card", 400);
        customers[6][1] = new Item("RAM", 150);
        customers[6][2] = new Item("SSD", 200);
        customers[6][3] = new Item("Power Supply", 90);

        customers[7][0] = new Item("Motherboard", 250);
        customers[7][1] = new Item("CPU", 350);
        customers[7][2] = new Item("Cooling Fan", 60);
        customers[7][3] = new Item("Case", 70);

        customers[8][0] = new Item("Phone Case", 20);
        customers[8][1] = new Item("Screen Protector", 10);
        customers[8][2] = new Item("Car Charger", 15);
        customers[8][3] = new Item("Wireless Earbuds", 90);

        customers[9][0] = new Item("Smart Bulb", 25);
        customers[9][1] = new Item("Smart Plug", 30);
        customers[9][2] = new Item("Security Camera", 150);
        customers[9][3] = new Item("Doorbell", 80);
        return customers;
    }
}
