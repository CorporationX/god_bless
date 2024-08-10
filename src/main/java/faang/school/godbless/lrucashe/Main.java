package faang.school.godbless.lrucashe;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        DataService dataService = new DataService();

        Data data1 = new Data(1, "data1", LocalDateTime.of(2018, 1, 1, 1, 1));
        Data data2 = new Data(2, "data2", LocalDateTime.of(2019, 1, 1, 1, 1));
        Data data3 = new Data(3, "data3", LocalDateTime.of(2020, 1, 1, 1, 1));
        Data data4 = new Data(4, "data4", LocalDateTime.of(2021, 1, 1, 1, 1));
        Data data5 = new Data(5, "data5", LocalDateTime.of(2022, 1, 1, 1, 1));
        Data data6 = new Data(6, "data6", LocalDateTime.of(2023, 1, 1, 1, 1));

        dataService.addData(data1);
        dataService.addData(data2);
        dataService.addData(data3);
        dataService.addData(data4);
        dataService.addData(data5);
        dataService.addData(data6);

        dataService.showData();
        System.out.println();

        System.out.println(dataService.getDataById(5));

        try {
            dataService.getDataById(1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
