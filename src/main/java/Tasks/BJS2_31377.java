package Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BJS2_31377 {
	public void run() {
		List<User> users = User.getUsersList();
		Map<Integer, List<User>> groupUser;
		
		System.out.println("Не отсортированный список пользователей");
		User.showUsers(users);
		groupUser = User.groupUser(users);
		System.out.println("Коллекции Map состоящий из ключа " + "возраста пользователей и списка пользователей");
		User.showUsersSortedByAge(groupUser);
	}
}

class User {
	private String name;
	private int age;
	private String workPlace;
	private String address;
	
	public User(
			String name, int age, String workPlace, String address
	) {
		this.name = name;
		this.age = age;
		this.workPlace = workPlace;
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getInformation() {
		return String.format("Я %s. Мой возраст : %d. Мой адрес : %s. Работаю в : %s", name, age, address, workPlace);
	}
	
	public static void showUsers(List<User> users) {
		for (User user : users) {
			System.out.println(user.getInformation());
		}
		
		System.out.println();
	}
	
	public static void showUsersSortedByAge(
			Map<Integer, List<User>> users
	) {
		for (Integer age : users.keySet()) {
			System.out.println(String.format("Пользователи чей возраст : %d", age));
			showUsers(users.get(age));
		}
		
		System.out.println();
	}
	
	public static Map<Integer, List<User>> groupUser(List<User> users) {
		Map<Integer, List<User>> groupedUsersByAge = new TreeMap<>();
		
		for (User user : users) {
			groupedUsersByAge.putIfAbsent(user.age, new ArrayList<>());
			groupedUsersByAge.get(user).add(user);
		}
		
		return groupedUsersByAge;
	}
	
	public static List<User> getUsersList() {
		return List.of(
				new User("Алексей", 30, "Яндекс", "г. Москва, ул. Ленина, д. 10"),
				new User("Дмитрий", 18, "Роснефть", "г. Казань, ул. Баумана, д. 12"),
				new User("Мария", 30, "Сбербанк", "г. Санкт-Петербург, Невский пр., д. 25"),
				new User("Екатерина", 22, "Лукойл", "г. Новосибирск, ул. Ленина, д. 5"),
				new User("Иван", 32, "Газпром", "г. Екатеринбург, проспект Ленина, д. 20"),
				new User("Ольга", 30, "РЖД", "г. Нижний Новгород, ул. Горького, д. 8"),
				new User("Сергей", 19, "МТС", "г. Самара, ул. Куйбышева, д. 18"),
				new User("Анна", 55, "Билайн", "г. Ростов-на-Дону, ул. Советская, д. 11"),
				new User("Николай", 20, "Мегафон", "г. Челябинск, проспект Победы, д. 4"),
				new User("Вера", 32, "Тинькофф", "г. Омск, ул. Гагарина, д. 15")
		);
	}
}