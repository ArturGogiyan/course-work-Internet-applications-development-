package test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.entities.AtmosphereEntity;
import test.entities.PeopleEntity;
import test.entities.PlanetsEntity;
import test.repository.AtmosphereRepository;
import test.repository.PlanetRepository;

import javax.servlet.http.HttpSession;
import java.util.Iterator;

@Controller
@RestController
public class AtmosphereController {
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private AtmosphereRepository atmosphereRepository;
    @RequestMapping(value = "/atmosphere", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    String main(HttpSession session) {
        String order = "<section class=\"engine\"><a href=\"https://mobirise.co/i\">how to build a website</a></section><section class=\"mbr-section mbr-section--relative mbr-section--fixed-size mbr-after-navbar\" id=\"pricing-table1-11\" data-rv-view=\"69\" style=\"background-color: rgb(240, 240, 240);\">\n" +
                "\n" +
                "    <div class=\"mbr-section__container mbr-section__container--std-top-padding container\" style=\"padding-top: 93px; margin-bottom: 0px;\">\n";
        if(session.getAttribute("ROLE_ADMIN")!=null){ order = order.concat("                        <form action=\"/addAtmosphere\" method=\"get\" data-form-title=\"change user rights&amp;nbsp;HERE\">\n" +
                "                            <input type=\"hidden\" value=\"TMB6qNe4ln8DbnhaZMJP2ldPr/Nqsxob22/QkOOma9dbQUoIU3kBQbqa0GFm/Ep6nTvdfcPqsO8+nVdR8S8vyND6rBjTlGXcA7SeHvzY5BQ1vdn2mxeRmbmSiLU8qX2B\" data-form-email=\"true\">\n" +
                "                            <div class=\"form-group\">\n" +
                "                            </div>\n" +
                "<input type=\"text\" class=\"form-control\" name=\"type\" required placeholder=\"atmosphere type\">\n" +
                "                            <div class=\"form-group\">\n" +
                "<input type=\"text\" class=\"form-control\" name=\"info\" required placeholder=\"information about\">\n" +
                "                            </div>\n" +
                "<div class=\"mbr-buttons mbr-buttons--right\"><button type=\"submit\" class=\"mbr-buttons__btn btn btn-lg btn-danger\">ADD</button></div>" +
                "                        </form>");}
                order = order.concat("                <table>\n" +
                "<tr>\n" +
                "  <th>Type</th>\n" +
                "  <th>Information</th>\n" +
                "</tr>\n");
        Iterator<AtmosphereEntity> iter = atmosphereRepository.findAll().iterator();
        while(iter.hasNext()){
            AtmosphereEntity planetsEntity = iter.next();
            order = order.concat("                <tr>\n" +
                    "                    <td>\n"+ planetsEntity.getType()+"\n" +
                    "                    </td>\n" +
                    "                    <td>"+planetsEntity.getInformation()+"\n" +
                    "                </td>\n" +
                    "                </tr>");
        }
        order = order.concat("            </table>\n" +
                "            </p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</section>");
        return order;
    }
    @RequestMapping(value = "/addAtmosphere", method = RequestMethod.GET)
    public @ResponseBody String addPlanet (@RequestParam String type
            , @RequestParam String info) {
        AtmosphereEntity entity = new AtmosphereEntity();
        entity.setType(type);
        entity.setInformation(info);
        atmosphereRepository.save(entity);
        return "Saved";
    }
}
