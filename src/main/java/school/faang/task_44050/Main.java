package school.faang.task_44050;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    List<User> usersList = new ArrayList<>();
    usersList.add(new User("Harry Potter", 17, "Gryffindor", "Gryffindor Tower, Hogwarts"));
    usersList.add(new User("Hermione Granger", 17, "Gryffindor", "Gryffindor Tower, Hogwarts"));
    usersList.add(new User("Ron Weasley", 17, "Gryffindor", "Gryffindor Tower, Hogwarts"));
    usersList.add(new User("Draco Malfoy", 17, "Slytherin", "Slytherin Common Room, Hogwarts"));
    usersList.add(new User("Ginny Weasley", 16, "Gryffindor", "Gryffindor Tower, Hogwarts"));
    usersList.add(new User("Neville Longbottom", 17, "Gryffindor", "Gryffindor Tower, Hogwarts"));
    usersList.add(new User("Luna Lovegood", 16, "Ravenclaw", "Ravenclaw Tower, Hogwarts"));
    usersList.add(new User("Severus Snape", 40, "Potions Master", "Hogwarts"));
    usersList.add(new User("Albus Dumbledore", 100, "Headmaster", "Hogwarts"));
    usersList.add(new User("Rubeus Hagrid", 50, "Keeper of Keys and Grounds", "Hogwarts"));
    Map<Integer, List<User>> groupedUsers = User.groupUsers(usersList);
    String formattedOutput = User.formatGroupedUsersToPrettyView(groupedUsers);
    System.out.println(formattedOutput);
    System.out.println(groupedUsers);
  }
}


