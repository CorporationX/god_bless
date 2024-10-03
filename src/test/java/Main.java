

public class Main {

        public static void main(String[] args) {
            User Vasy = new User("Vasy", 18, "hgh", "Voronezh");
            User Kyza = new User("Kyza", 33, "II", "Piter");
            User Vlad = new User("Vlad", 16, "ggg", "Moscow");
            add(Vasy);
            add(Kyza);
            add(Vlad);

            Map<Integer, List<User>> group = User.groupUsers(userList);

            printAll(group);
        }

        private static void add(User user) {
            userList.add(user);
        }
}
