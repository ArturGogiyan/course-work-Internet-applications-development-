package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import test.entities.PeopleEntity;
import test.entities.RolesEntity;
import test.repository.PeopleRepository;
import test.repository.RolesRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private RolesRepository rolesRepository;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView testq( HttpSession session,
//    @RequestBody User user
   HttpServletRequest request
    ) {
//        String login = user.getLogin();
//        String password = user.getPassword();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("login:"+login+"; password:"+password);
        PeopleEntity peopleEntity = peopleRepository.findByUserName(login);

        if(peopleEntity.getPassword().equals(password)){
            session.setAttribute("id", peopleEntity.getId());
            session.setAttribute("password", password);

            List<RolesEntity> list = rolesRepository.findByUserName(login);
            for(RolesEntity rolesEntity: list){
                session.setAttribute(rolesEntity.getRoleName(),rolesEntity.getRoleName());
                System.out.println("roleName:"+rolesEntity.getRoleName());
            }
            modelAndView.setViewName("redirect:/");
        }else modelAndView.setViewName("redirect:/#/autentification");
        return modelAndView;
    }

}
