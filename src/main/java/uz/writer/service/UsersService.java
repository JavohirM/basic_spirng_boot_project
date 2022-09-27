package uz.writer.service;

import org.springframework.stereotype.Service;
import uz.writer.dao.model.InMemoryUsers;
import uz.writer.dao.model.Users;

@Service
public class UsersService {

    public Users getByUserName(String username) {
        if (InMemoryUsers.INSTANCE.getValues() == null)
            return new Users();
        return InMemoryUsers.INSTANCE.getValues().stream().filter(u -> u.getUsername().equals(username)).findFirst()
                .orElseThrow(() -> new RuntimeException("Could Find User with username : " + username));

    }

    public Users createUsers(Users users) {
        InMemoryUsers.INSTANCE.addValue(users);
        return InMemoryUsers.INSTANCE.getValues().stream().filter(u -> u.getUsername().equals(users.getUsername())).findFirst()
                .orElseThrow(() -> new RuntimeException("Could Not Save User To DB!"));
    }
}
