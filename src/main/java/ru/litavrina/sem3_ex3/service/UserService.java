package ru.litavrina.sem3_ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.litavrina.sem3_ex3.domain.User;

@Service
public class UserService {
    @Autowired
    private NotificationService notificationService;
    //    public UserService(NotificationService notificationService) {
    //        this.notificationService = notificationService;
    //    }

    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
}
