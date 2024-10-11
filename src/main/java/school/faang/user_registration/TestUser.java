package school.faang.user_registration;

import lombok.Data;

@Data
public class TestUser {
    public static void main(String[] args) {
        User user1 = new User("David", 25, "Google", "Amsterdam");
        System.out.println(user1);


    }
}
