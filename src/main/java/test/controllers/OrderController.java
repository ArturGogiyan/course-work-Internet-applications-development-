package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import test.entities.FlightsEntity;
import test.entities.PlanetsEntity;
import test.repository.FlightRepository;
import test.repository.PlanetRepository;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RestController
public class OrderController {
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public @ResponseBody
    String newOrder(HttpSession session) {
        if (session.getAttribute("ROLE_USER") != null || session.getAttribute("ROLE_ADMIN")!=null || session.getAttribute("ROLE_WORKER")!=null) {
            String order = "<section class=\"engine\"><a href=\"https://mobirise.co/i\">build your own website</a></section><section class=\"mbr-section mbr-section--relative mbr-section--fixed-size mbr-parallax-background mbr-after-navbar\" id=\"content5-h\" data-rv-view=\"40\" style=\"background-image: url(assets/images/bg3.jpg);\">\n" +
                    "    <div class=\"mbr-overlay\" style=\"opacity: 0.6; background-color: rgb(40, 50, 78);\"></div>\n" +
                    "    <div class=\"mbr-section__container container mbr-section__container--first\" style=\"padding-top: 93px;\">\n" +
                    "        <div class=\"mbr-header mbr-header--wysiwyg row\">\n" +
                    "            <div class=\"col-sm-8 col-sm-offset-2\">\n" +
                    "                <h3 class=\"mbr-header__text\">YOUR ORDERS</h3>\n" +
                    "\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "    <div class=\"mbr-section__container container mbr-section__container--middle\">\n" +
                    "        <div class=\"row\">\n" +
                    "            <div class=\"mbr-article mbr-article--wysiwyg col-sm-8 col-sm-offset-2\"><p>here you can see orders you book for all time. If you want to create new order, push button with the same name.</p></div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "    <div class=\"mbr-section__container container mbr-section__container--last\" style=\"padding-bottom: 93px;\">\n" +
                    "        <div class=\"row\">\n" +
                    "            <div class=\"col-sm-8 col-sm-offset-2\">\n" +
                    "                <div class=\"mbr-buttons mbr-buttons--center btn-inverse\"><a class=\"mbr-buttons__btn btn btn-lg btn-default\" href=\"#/newOrder\">CREATE NEW ORDER</a></div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</section>\n" +
                    "\n" +
                    "<section class=\"mbr-section\" id=\"content1-u\" data-rv-view=\"43\">\n" +
                    "    <div class=\"mbr-section__container container mbr-section__container--isolated\">\n" +
                    "        <div class=\"row\">\n" +
                    "            <div class=\"mbr-article mbr-article--wysiwyg col-sm-8 col-sm-offset-2\">";
            List<FlightsEntity> list = flightRepository.findAllByClientId((int)session.getAttribute("id"));
            if (list.size()==0) order = order.concat("you don't have any orders yet.");
            else order = order.concat("your orders:" +
                    "<p><table>");
            for(FlightsEntity flightsEntity: list){
                PlanetsEntity startPlanet = planetRepository.findByName(flightsEntity.getStartPlanetName());
                PlanetsEntity finishPlanet = planetRepository.findByName(flightsEntity.getFinishPlanetName());
                order = order.concat("                <tr>\n" +
                        "                    <td>\n" +
                        "                        <p>start planet: "+startPlanet.getName()+"<p>"+
                        "                        <img src=\""+startPlanet.getImageURL()+"\" width=\"200px\" height=\"200px\"/>\n" +
                        "                </td>\n" +
                                "                    <td>\n" +
                                "                        <p>destination planet: "+finishPlanet.getName()+"<p>"+
                        "                        <img src=\""+finishPlanet.getImageURL()+"\" width=\"200px\" height=\"200px\"/>\n" +
                                "                </td>\n" +
                                "<td>parcel type: "+flightsEntity.getCargoType()+"<p>delivery date: "+flightsEntity.getDateOfFlight()+
                        "<p>weight: "+flightsEntity.getWeight()+
                        "<p>cost: $"+(int)(new NewOrderController().getCost(flightsEntity, startPlanet, finishPlanet))+"</td></tr>");
            }
                    order = order.concat("</table></div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</section>\n");
            return order;
        }
        return "<section class=\"engine\"><a href=\"https://mobirise.co/i\">how to build a website</a></section><section class=\"mbr-section mbr-section--relative mbr-section--fixed-size mbr-after-navbar\" id=\"pricing-table1-11\" data-rv-view=\"69\" style=\"background-color: rgb(240, 240, 240);\">\n" +
                "\n" +
                "    <div class=\"mbr-section__container mbr-section__container--std-top-padding container\" style=\"padding-top: 93px; margin-bottom: 0px;\">\n" +
                "<h3>Access Denied</h3></div>\n" +
                "</section>";
    }
}
