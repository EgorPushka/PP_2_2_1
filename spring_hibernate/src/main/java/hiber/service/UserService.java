package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User addCarToUser(User user, Car car);

    void printUserInfo(User user);

    List<User> getUserByCarModel(String model, int series);
}
