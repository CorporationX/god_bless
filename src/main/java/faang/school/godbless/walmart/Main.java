package faang.school.godbless.walmart;

public class Main {
    public static void main(String[] args) {
        String[][] customers = new String[3][3];
        customers[0][0] = "Мёд";
        customers[0][1] = "Чай";
        customers[0][2] = "Печенье";
        customers[1][0] = "Шоколад";
        customers[1][1] = "Кофе";
        customers[0][2] = "Сливки";
        customers[2][0] = "Вода";
        customers[2][1] = "Вино";
        customers[2][2] = "Сыр";
        CashierThread[] cashiers = new CashierThread[customers.length];
        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
        }
        for(var cashierThread : cashiers){
            cashierThread.start();
        }
        System.out.println("Общее количество обработанных товаров = " +
                CashierThread.items);
    }
}
