package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
public class PlanetController {
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private AtmosphereRepository atmosphereRepository;
    @RequestMapping(value = "/planet", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    String main(HttpSession session) {
        String order = "<section class=\"engine\"><a href=\"https://mobirise.co/i\">how to build a website</a></section><section class=\"mbr-section mbr-section--relative mbr-section--fixed-size mbr-after-navbar\" id=\"pricing-table1-11\" data-rv-view=\"69\" style=\"background-color: rgb(240, 240, 240);\">\n" +
                "\n" +
                "    <div class=\"mbr-section__container mbr-section__container--std-top-padding container\" style=\"padding-top: 93px; margin-bottom: 0px;\">\n";
        if(session.getAttribute("ROLE_ADMIN")!=null) order = order.concat("                        <form action=\"/addPlanet\" method=\"get\" data-form-title=\"change user rights&amp;nbsp;HERE\">\n" +
                "                            <input type=\"hidden\" value=\"TMB6qNe4ln8DbnhaZMJP2ldPr/Nqsxob22/QkOOma9dbQUoIU3kBQbqa0GFm/Ep6nTvdfcPqsO8+nVdR8S8vyND6rBjTlGXcA7SeHvzY5BQ1vdn2mxeRmbmSiLU8qX2B\" data-form-email=\"true\">\n" +
                "                            <div class=\"form-group\">\n" +
                "                                <select name=\"atmosphereType\">\n" +
                "                                    <option>select atmosphere type:</option>\n");
        Iterator<AtmosphereEntity> iterr = atmosphereRepository.findAll().iterator();
        while (iterr.hasNext()) {
            order = order.concat("                                    <option>" + iterr.next().getType() + "</option>\n");
        }
        order = order.concat("                                </select>\n" +
                "                            </div>\n" +
                "                            <div class=\"form-group\">\n" +
                "<input type=\"text\" class=\"form-control\" name=\"name\" required placeholder=\"name\">\n" +
                "<input type=\"text\" class=\"form-control\" name=\"coordX\" required placeholder=\"coordinate X\">\n" +
                "<input type=\"text\" class=\"form-control\" name=\"coordY\" required placeholder=\"coordinate Y\">\n" +
                "<input type=\"text\" class=\"form-control\" name=\"coordZ\" required placeholder=\"coordinate Z\">\n" +
                "<input type=\"text\" class=\"form-control\" name=\"imageURL\" required placeholder=\"image URL\">\n" +
                "                            </div>\n" +
                "<div class=\"mbr-buttons mbr-buttons--right\"><button type=\"submit\" class=\"mbr-buttons__btn btn btn-lg btn-danger\">ADD</button></div>" +
                "                        </form>");
        order = order.concat("                <table>\n");
        Iterator<PlanetsEntity> iter = planetRepository.findAll().iterator();
        while(iter.hasNext()){
            PlanetsEntity planetsEntity = iter.next();
            order = order.concat("                <tr>\n" +
                    "                    <td>\n" +
                    "                        <img src=\""+planetsEntity.getImageURL()+"\" width=\"400px\" height=\"400px\"/>\n" +
                    "                    </td>\n" +
                    "                    <td><h2>"+planetsEntity.getName()+"</h2>\n" +
                    "                <p>Coordinates: {"+planetsEntity.getCoordX()+";"+planetsEntity.getCoordY()+";"+planetsEntity.getCoordZ()+"}</p>\n" +
                    "                <p>Atmosphere type:"+planetsEntity.getAtmosphereType()+"</p>\n" +
                    "                <p>Information about:"+atmosphereRepository.getAtmosphereEntitiesByType(planetsEntity.getAtmosphereType()).getInformation()+"</p>\n" +
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
    @RequestMapping(value = "/addPlanet", method = RequestMethod.GET)
    public @ResponseBody String addPlanet (@RequestParam String atmosphereType
            , @RequestParam String coordX, @RequestParam String coordY
            , @RequestParam String coordZ, @RequestParam String name,
                                           @RequestParam String imageURL) {
        PlanetsEntity entity = new PlanetsEntity();
        entity.setAtmosphereType(atmosphereType);
        entity.setCoordX(Integer.parseInt(coordX));
        entity.setCoordY(Integer.parseInt(coordY));
        entity.setCoordZ(Integer.parseInt(coordZ));
        entity.setName(name);
        entity.setImageURL(imageURL);
        planetRepository.save(entity);
        return "Saved";
    }
}
