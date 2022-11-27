package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User newUser = new User("User1", "Lastname1", "user1@mail.ru");
        newUser.setPrivateCar(new Car("Tesla", 1200));
        userService.add(newUser);

        newUser = new User("User2", "Lastname2", "user2@mail.ru");
        newUser.setPrivateCar(new Car("Tesla", 1210));
        userService.add(newUser);

        newUser = new User("User3", "Lastname3", "user3@mail.ru");
        newUser.setPrivateCar(new Car("Tesla", 1220));
        userService.add(newUser);

        newUser = new User("User4", "Lastname4", "user4@mail.ru");
        newUser.setPrivateCar(new Car("Tesla", 1230));
        userService.add(newUser);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        User bestUser = userService.findUserByModelAndSeries("Tesla", 1230);
        if (bestUser != null) {
            System.out.println("Пользователь года: " + bestUser);
        } else {
            System.out.println("Не найден владелец машины");
        }

        context.close();
    }
}
