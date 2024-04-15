package faang.school.godbless.indexELK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<User, List<Query>> usersRequests = new HashMap<>();
    public static void main(String[] args) {


    }

    private void addUserAndRequests(int idUser, String nameUser, int idRequest, String contentRequest,
                                    Date timestampRequest) {
        User newUser = new User(idUser, nameUser);
        Query newRequest = new Query(idRequest, contentRequest, timestampRequest);
        List<Query> newListRequests = new ArrayList<>();
        newListRequests.add(newRequest);
        usersRequests.put(newUser, newListRequests);
    }

    private void addNewRequestForExistingUser(int idUser, String nameUser, int idRequest, String contentRequest,
                                              Date timestampRequest) {
        User user = new User(idUser, nameUser);
        Query newRequest = new Query(idRequest, contentRequest, timestampRequest);
        usersRequests.get(user).add(newRequest);
    }

    private void removeUserAndHisRequests(int idUser, String nameUser) {
        User user = new User(idUser, nameUser);
        usersRequests.remove(user);
    }

    private void displayInfoAboutUsersAndRequests() {
        for (Map.Entry<User, List<Query>> entry : usersRequests.entrySet()) {
            System.out.println("Пользователь " + entry.getKey() + " имеет следующие запросы: "
                    + entry.getValue());
        }
    }

    private void displayInfoAboutOneUserAndHisRequests() {
        for (Map.Entry<User, List<Query>> entry : usersRequests.entrySet()) {
            Collections.sort(entry.getValue(), new QueryComparator());
            System.out.println("Пользователь " + entry.getKey().getName() + " имеет следующие запросы: "
                    + entry.getValue());
        }
    }
}
