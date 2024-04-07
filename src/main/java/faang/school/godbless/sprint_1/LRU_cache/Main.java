package faang.school.godbless.sprint_1.LRU_cache;

public class Main {

    public static void main(String[] args) {
        CustomDataStorage customDataStorage = new CustomDataStorage(3);

        // add start data, all should be in cache
        customDataStorage.addData(new Data("something"));
        customDataStorage.addData(new Data("new"));
        customDataStorage.addData(new Data("last in cache"));
        customDataStorage.printInfoAboutCache();
        System.out.println();

        // timestamp in data with id 0 should be updated
        customDataStorage.getDataById(0);

        customDataStorage.printInfoAboutCache();
        System.out.println();

        // this data put in cache instead of oldest data
        customDataStorage.addData(new Data("more then cache"));

        customDataStorage.printInfoAboutCache();
        System.out.println();

        // timestamp in data with id 1 should be updated, data put in cache instead of oldest data
        customDataStorage.getDataById(1);

        customDataStorage.printInfoAboutCache();
        System.out.println();

        // timestamp in data with id 2 should be updated, data put in cache instead of oldest data
        customDataStorage.getDataById(2);

        customDataStorage.printInfoAboutCache();
    }
}
