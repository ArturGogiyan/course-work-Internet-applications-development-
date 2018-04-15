package test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.entities.PeopleEntity;
import test.entities.PlanetsEntity;
import test.entities.RolesEntity;
import test.repository.PeopleRepository;
import test.repository.RolesRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;

@Controller
@RestController
public class UsersController {
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @RequestMapping(value = "/workers", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    String main(HttpSession session) {

        String order = "<section class=\"engine\"><a href=\"https://mobirise.co/i\">how to build a website</a></section><section class=\"mbr-section mbr-section--relative mbr-section--fixed-size mbr-after-navbar\" id=\"pricing-table1-11\" data-rv-view=\"69\" style=\"background-color: rgb(240, 240, 240);\">\n" +
                "\n" +
                "    <div class=\"mbr-section__container mbr-section__container--std-top-padding container\" style=\"padding-top: 93px; margin-bottom: 0px;\">\n";
        if (session.getAttribute("ROLE_ADMIN") == null && session.getAttribute("ROLE_WORKER") == null)
            order = order.concat("Access Denied</div>\n" +
                    "</section>");
        else {
            if(session.getAttribute("ROLE_ADMIN")!=null){ order = order.concat("                        <form action=\"/changeUserRights\" method=\"get\" data-form-title=\"change user rights&amp;nbsp;HERE\">\n" +
                    "                            <input type=\"hidden\" value=\"TMB6qNe4ln8DbnhaZMJP2ldPr/Nqsxob22/QkOOma9dbQUoIU3kBQbqa0GFm/Ep6nTvdfcPqsO8+nVdR8S8vyND6rBjTlGXcA7SeHvzY5BQ1vdn2mxeRmbmSiLU8qX2B\" data-form-email=\"true\">\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <select name=\"username\">\n" +
                    "                                    <option>select username:</option>\n");
            Iterator<PeopleEntity> iterr = peopleRepository.findAll().iterator();
            while (iterr.hasNext()) {
                order = order.concat("                                    <option>" + iterr.next().getUserName() + "</option>\n");
            }
            order = order.concat("                                </select>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <select name=\"role\">\n" +
                    "                                    <option>user role</option>\n" +
                    "                                    <option>USER</option>\n" +
                    "                                    <option>WORKER</option>\n" +
                    "                                    <option>ADMIN</option>\n" +
                    "                                </select>\n" +
                    "                            </div>\n" +
                    "<div class=\"mbr-buttons mbr-buttons--right\"><button type=\"submit\" class=\"mbr-buttons__btn btn btn-lg btn-danger\">CHANGE</button></div>" +
                    "                        </form>");}
            order = order.concat(
                    "<table>\n" +
                            "<tr>\n" +
                            "  <th>login</th>\n" +
                            "  <th>name</th>\n" +
                            "  <th>surname</th>\n" +
                            "  <th>birthday date</th>\n" +
                            "  <th>role</th>\n" +
                            "</tr>\n");

            for (PeopleEntity peopleEntity : peopleRepository.findAll()) {
                int role = 0, i = 0;
                for (RolesEntity rolesEntity : rolesRepository.findByUserName(peopleEntity.getUserName())) {
                    if (rolesEntity.getRoleName().equals("ROLE_USER")) i = 1;
                    else if (rolesEntity.getRoleName().equals("ROLE_WORKER")) i = 2;
                    else if (rolesEntity.getRoleName().equals("ROLE_ADMIN")) i = 3;
                    if (i > role) role = i;
                }
                String roleName = "";
                switch (i) {
                    case 1:
                        roleName = "USER";
                        break;
                    case 2:
                        roleName = "WORKER";
                        break;
                    case 3:
                        roleName = "ADMIN";
                        break;
                }
                order = order.concat("<tr>\n" +
                        "  <td>" + peopleEntity.getUserName() + "</td>\n" +
                        "  <td>" + peopleEntity.getName() + "</td>\n" +
                        "  <td>" + peopleEntity.getSurname() + "</td>\n" +
                        "  <td>" + peopleEntity.getBirthdayDate() + "</td>\n" +
                        "  <td>" + roleName + "</td></tr>\n");
            }
            order = order.concat("</table>" +
                    "    </div>\n" +
                    "</section>");


        }
        return order;
    }

    @RequestMapping(value = "/changeUserRights", method = RequestMethod.GET)
    public ModelAndView test(@RequestParam String username, @RequestParam String role, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/AccessDeniedPage");
        System.out.println("change role: "+role);
        if(session.getAttribute("ROLE_ADMIN")!=null) {
            rolesRepository.deleteByUserName(username);
            RolesEntity rolesEntity = new RolesEntity();
            rolesEntity.setRoleName("ROLE_USER");
            rolesEntity.setUserName(username);
            rolesRepository.save(rolesEntity);
            if(role.equals("WORKER")){
                rolesEntity.setRoleName("ROLE_WORKER");
                rolesEntity.setUserName(username);
                rolesRepository.save(rolesEntity);
            }else if(role.equals("ADMIN")){
                rolesEntity.setRoleName("ROLE_ADMIN");
                rolesEntity.setUserName(username);
                rolesRepository.save(rolesEntity);
            }
            modelAndView.setViewName("redirect:/workerPage");
        }
        return modelAndView;
    }
}
