package ru.litavrina.sem3_ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.litavrina.sem3_ex3.domain.User;

@Service
public class RegistrationService {
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;
    //Поля UserService, NotificationService

    public String processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService
                .addUserToList(newUser);
         return notificationService.notifyUser(newUser);
    }

}
