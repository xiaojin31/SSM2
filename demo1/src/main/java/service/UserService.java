package service;


import mapper.UserMapper;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id){
        logger.info("getUserById() id="+id);

        User user = new User();

        try{
            user = userMapper.getUserById(id);
        }catch (Exception e){
            logger.error("getUserById() id="+id,e);
            e.printStackTrace();
        }

        return user;
    }

}
