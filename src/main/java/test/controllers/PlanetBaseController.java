package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import test.entities.PlanetsEntity;
import test.repository.AtmosphereRepository;
import test.repository.PlanetRepository;

import java.util.Iterator;

@Controller
@RestController
public class PlanetBaseController {
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private AtmosphereRepository atmosphereRepository;
    @RequestMapping(value = "/planetBase", method = RequestMethod.GET)
    public @ResponseBody String planetBase() {
        return getOrder();
    }
    public String getOrder(){
        String order = "<section class=\"engine\"><a href=\"https://mobirise.co/o\">bootstrap button</a></section><section class=\"mbr-section mbr-section--relative mbr-section--fixed-size mbr-parallax-background mbr-after-navbar\" id=\"content5-r\" data-rv-view=\"48\" style=\"background-image: url(assets/images/bg3.jpg);\">\n" +
                "    <div class=\"mbr-overlay\" style=\"opacity: 0.2; background-color: rgb(40, 50, 78);\"></div>\n" +
                "    <div class=\"mbr-section__container container mbr-section__container--first\" style=\"padding-top: 93px;\">\n" +
                "        <div class=\"mbr-header mbr-header--wysiwyg row\">\n" +
                "            <div class=\"col-sm-8 col-sm-offset-2\">\n" +
                "                <h3 class=\"mbr-header__text\">BASE OF PLANETS</h3>\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"mbr-section__container container mbr-section__container--last\" style=\"padding-bottom: 93px;\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"mbr-article mbr-article--wysiwyg col-sm-8 col-sm-offset-2\"><p>Here you can get information about planets we work with.</p></div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "</section>\n" +
                "\n" +
                "<section class=\"mbr-section\" id=\"content1-t\" data-rv-view=\"51\">\n" +
                "    <div class=\"mbr-section__container container mbr-section__container--isolated\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"mbr-article mbr-article--wysiwyg col-sm-8 col-sm-offset-2\"><p>\n" +
                "                <table>\n";
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
}
