package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User u1 = new User("Jon", "Dow", "jon@dow.com");
        User u2 = new User("Bobi", "Fisher", "bobi@fisher.com");
        User u3 = new User("Mike", "Tyson", "iron@mike.com");
        User u4 = new User("Marti", "Mcfly", "backto@future.com");

        Car c1 = new Car("Audi", 2000);
        Car c2 = new Car("BMW", 3000);
        Car c3 = new Car("Ford", 4000);
        Car c4 = new Car("Delorian", 5000);

        userService.add(userService.addCarToUser(u1, c1));
        userService.add(userService.addCarToUser(u2, c2));
        userService.add(userService.addCarToUser(u3, c3));
        userService.add(userService.addCarToUser(u4, c4));

        List<User> users = userService.listUsers();
        for (User user : users) {
            userService.printUserInfo(user);
        }

        List<User> list = userService.getUserByCarModel("Audi",2000);
        System.out.println(list);

        context.close();
    }
}
