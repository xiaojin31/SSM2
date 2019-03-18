package mapper;

import model.User;

public interface UserMapper {

    void insertUser(User user);

    void updateUser(User user);

    User getUserById(int id);

}
