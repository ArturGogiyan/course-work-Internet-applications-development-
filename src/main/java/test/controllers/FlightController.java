package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import test.entities.FlightsEntity;
import test.repository.FlightRepository;

import javax.servlet.http.HttpSession;

@Controller
@RestController
public class FlightController {
    @Autowired
    private FlightRepository flightsRepository;
    @RequestMapping(value = "/flights", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    String main(HttpSession session) {

        String order = "<section class=\"engine\"><a href=\"https://mobirise.co/i\">how to build a website</a></section><section class=\"mbr-section mbr-section--relative mbr-section--fixed-size mbr-after-navbar\" id=\"pricing-table1-11\" data-rv-view=\"69\" style=\"background-color: rgb(240, 240, 240);\">\n" +
                "\n" +
                "    <div class=\"mbr-section__container mbr-section__container--std-top-padding container\" style=\"padding-top: 93px; margin-bottom: 0px;\">\n";
        if (session.getAttribute("ROLE_ADMIN") == null && session.getAttribute("ROLE_WORKER") == null)
            order = order.concat("Access Denied</div>\n" +
                    "</section>");
        else {
            order = order.concat(
                    "<table>\n" +
                            "<tr>\n" +
                            "  <th>start planet</th>\n" +
                            "  <th>destination plane</th>\n" +
                            "  <th>date</th>\n" +
                            "  <th>ship id</th>\n" +
                            "  <th>cargo type</th>\n" +
                            "  <th>weight</th>\n" +
                            "</tr>\n");

            for (FlightsEntity flightsEntity : flightsRepository.findAll()) {
                order = order.concat("<tr>\n" +
                        "  <td>" + flightsEntity.getStartPlanetName() + "</td>\n" +
                        "  <td>" + flightsEntity.getFinishPlanetName() + "</td>\n" +
                        "  <td>" + flightsEntity.getDateOfFlight() + "</td>\n" +
                        "  <td>" + flightsEntity.getShipId() + "</td>\n" +
                        "  <td>" + flightsEntity.getCargoType() + "</td></tr>\n" +
                        "  <td>" + flightsEntity.getWeight() + "</td></tr>\n");
            }
            order = order.concat("</table>" +
                    "    </div>\n" +
                    "</section>");


        }
        return order;
    }
}
