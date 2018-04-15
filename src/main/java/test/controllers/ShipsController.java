package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.entities.*;
import test.repository.AtmosphereRepository;
import test.repository.ShipRepository;

import javax.servlet.http.HttpSession;
import java.util.Iterator;

@Controller
@RestController
public class ShipsController {
    @Autowired
    private ShipRepository shipRepository;
    @Autowired
    private AtmosphereRepository atmosphereRepository;
    @RequestMapping(value = "/ships", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    String main(HttpSession session) {
        String order = "<section class=\"engine\"><a href=\"https://mobirise.co/i\">how to build a website</a></section><section class=\"mbr-section mbr-section--relative mbr-section--fixed-size mbr-after-navbar\" id=\"pricing-table1-11\" data-rv-view=\"69\" style=\"background-color: rgb(240, 240, 240);\">\n" +
                "\n" +
                "    <div class=\"mbr-section__container mbr-section__container--std-top-padding container\" style=\"padding-top: 93px; margin-bottom: 0px;\">\n";
        if (session.getAttribute("ROLE_ADMIN") == null && session.getAttribute("ROLE_WORKER") == null)
            order = order.concat("Access Denied</div>\n" +
                    "</section>");
        else {
            if(session.getAttribute("ROLE_ADMIN")!=null){ order = order.concat("                        <form action=\"/addShip\" method=\"get\" data-form-title=\"change user rights&amp;nbsp;HERE\">\n" +
                    "                            <input type=\"hidden\" value=\"TMB6qNe4ln8DbnhaZMJP2ldPr/Nqsxob22/QkOOma9dbQUoIU3kBQbqa0GFm/Ep6nTvdfcPqsO8+nVdR8S8vyND6rBjTlGXcA7SeHvzY5BQ1vdn2mxeRmbmSiLU8qX2B\" data-form-email=\"true\">\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <select name=\"atmosphere\">\n" +
                    "                                    <option>select atmosphere type: </option>\n");
            Iterator<AtmosphereEntity> iterr = atmosphereRepository.findAll().iterator();
            while (iterr.hasNext()) {
                order = order.concat("                                    <option>" + iterr.next().getType() + "</option>\n");
            }
            order = order.concat("                                </select>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "<input type=\"text\" class=\"form-control\" name=\"color\" required=\"\" placeholder=\"Color\" data-form-field=\"Name\">\n" +
                    "                            </div>\n" +
                    "<div class=\"mbr-buttons mbr-buttons--right\"><button type=\"submit\" class=\"mbr-buttons__btn btn btn-lg btn-danger\">ADD</button></div>" +
                    "                        </form>");}
            order = order.concat(
                    "<table>\n" +
                            "<tr>\n" +
                            "  <th>Atmosphere name</th>\n" +
                            "  <th>Color</th>\n" +
                            "  <th>Id</th>\n" +
                            "</tr>\n");

            for (ShipsEntity peopleEntity : shipRepository.findAll()) {
                order = order.concat("<tr>\n" +
                        "  <td>" + peopleEntity.getAtmosphereType() + "</td>\n" +
                        "  <td>" + peopleEntity.getColor() + "</td>\n" +
                        "  <td>" + peopleEntity.getId() + "</td>\n");
            }
            order = order.concat("</table>" +
                    "    </div>\n" +
                    "</section>");


        }
        return order;    }
    @RequestMapping(value = "/addShip", method = RequestMethod.GET)
    public @ResponseBody String addPlanet (@RequestParam String atmosphere
            , @RequestParam String color, HttpSession session) {
        if(session.getAttribute("ROLE_ADMIN")!=null){
        ShipsEntity entity = new ShipsEntity();
        entity.setAtmosphereType(atmosphere);
        entity.setColor(color);
        shipRepository.save(entity);
        return "saved";
        }
return "access denied";
    }
}
