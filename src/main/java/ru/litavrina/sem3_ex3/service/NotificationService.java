package ru.litavrina.sem3_ex3.service;

import org.springframework.stereotype.Service;
import ru.litavrina.sem3_ex3.domain.User;
@Service
public class NotificationService {
    public String notifyUser(User user) {
        String mesg = "A new user has been created: " + user.getName();
        System.out.println(mesg);
        return mesg;
    }

    public void sendNotification(String s) {
        System.out.println(s);
    }
}
