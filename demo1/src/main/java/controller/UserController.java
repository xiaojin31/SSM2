package controller;


import com.alibaba.fastjson.JSONObject;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class UserController {
    private static Logger logger=Logger.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    // /user/test?id=1
    @RequestMapping(value="/getuser",method= RequestMethod.POST)
    @ResponseBody
    public Object getUserById(HttpServletRequest request){
        logger.info("getUserById()");

        JSONObject retnJson =new JSONObject();

        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            System.out.println("userId:"+userId);

            User user = userService.getUserById(userId);

            retnJson.put("data",user);
            retnJson.put("status",100);
        }catch (Exception e){
            logger.error("getUserById()",e);
            retnJson.put("status",101);
        }

        return retnJson;
    }
}
