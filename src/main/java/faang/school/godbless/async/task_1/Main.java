package faang.school.godbless.async.task_1;

import faang.school.godbless.async.task_1.service.MasterCardService;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
