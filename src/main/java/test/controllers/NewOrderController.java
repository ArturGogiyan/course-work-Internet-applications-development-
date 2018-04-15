package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.entities.FlightsEntity;
import test.entities.PeopleEntity;
import test.entities.PlanetsEntity;
import test.repository.FlightRepository;
import test.repository.PeopleRepository;
import test.repository.PlanetRepository;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RestController
public class NewOrderController {
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private PeopleRepository peopleRepository;
    @RequestMapping(value = "/newOrder", method = RequestMethod.GET)
    public @ResponseBody
    String newOrder(HttpSession session) {
        if(session.getAttribute("ROLE_USER") != null || session.getAttribute("ROLE_ADMIN")!=null || session.getAttribute("ROLE_WORKER")!=null) {
            String order = "<section class=\"engine\"><a href=\"https://mobirise.co/g\">how to create a website for free</a></section><section class=\"mbr-section mbr-section--relative mbr-section--fixed-size mbr-after-navbar\" id=\"form1-x\" data-rv-view=\"56\" style=\"background-color: rgb(193, 193, 193);\">\n" +
                    "\n" +
                    "    <div class=\"mbr-section__container mbr-section__container--std-padding container\" style=\"padding-top: 93px; padding-bottom: 93px;\">\n" +
                    "        <div class=\"row\">\n" +
                    "            <div class=\"col-sm-12\">\n" +
                    "                <div class=\"row\">\n" +
                    "                    <div class=\"col-sm-8 col-sm-offset-2\" data-form-type=\"formoid\">\n" +
                    "                        <div class=\"mbr-header mbr-header--center mbr-header--std-padding\">\n" +
                    "                            <h2 class=\"mbr-header__text\">NEW ORDER</h2>\n" +
                    "                        </div>\n" +
                    "                        <div data-form-alert=\"true\">\n" +
                    "                            <div class=\"hide\" data-form-alert-success=\"true\">Thanks for filling out form!</div>\n" +
                    "                        </div>\n" +
                    "                        <form action=\"/addOrder\" method=\"get\" data-form-title=\"NEW ORDER\">\n" +
                    "                            <input type=\"hidden\" value=\"WphUWg77iggDQFEy0/harFY7LvQ5LK3uUewE+OVmGXl62gzy4OpWSp3v0TDy+vFDkWJRuBS0hS/JIqBXfWT/aedpPfvNNXTWom55BqkTJkcvnSecuppjkDr4cWw72sOF\" data-form-email=\"true\">\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <select name=\"cargoType\" id=\"cargoType\">\n" +
                    "                                    <option>select type of delivery:</option>\n" +
                    "                                    <option>default</option>\n" +
                    "                                    <option>safety</option>\n" +
                    "                                    <option>fast</option>\n" +
                    "                                    <option>premium</option>\n" +
                    "                                </select>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <input type=\"text\" class=\"form-control\" name=\"weight\" id=\"weight\" required placeholder=\"enter the mass of the load\">\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <select name=\"firstPlanet\" id=\"firstPlanet\">\n" +
                    "                                    <option>select start planet:</option>\n";

            Iterator<PlanetsEntity> iter = planetRepository.findAll().iterator();
            while (iter.hasNext()) {
                order = order.concat("                                    <option>" + iter.next().getName() + "</option>\n");
            }
            order = order.concat("                                </select>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <select name=\"secondPlanet\" id=\"secondPlanet\">\n" +
                    "                                    <option>select type of delivery:</option>\n");
            Iterator<PlanetsEntity> iterr = planetRepository.findAll().iterator();
            while (iterr.hasNext()) {
                order = order.concat("                                    <option>" + iterr.next().getName() + "</option>\n");
            }
            order = order.concat("                                </select>\n" +
                    "                            </div>\n" +
//                    "                            <div class=\"mbr-buttons mbr-buttons--right\"><button type=\"button\" class=\"mbr-buttons__btn btn btn-lg btn-danger\" onclick=\"calculateCost()\">CALCULATE COST</button></div>\n" +
                    "                            <div class=\"mbr-buttons mbr-buttons--right\"><button type=\"submit\" class=\"mbr-buttons__btn btn btn-lg btn-danger\">CREATE ORDER</button></div>\n" +
                    "                        </form>\n" +
                    "<div id=\"cost\"></div>" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</section>\n" +
                    "<label class=\"label\">Страны Великобритании:</label>\n");
            return order;
        }
        return "access denied";
    }
    @RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    public ModelAndView addPlanet (@RequestParam String firstPlanet
            , @RequestParam String secondPlanet, @RequestParam String weight
            , @RequestParam String cargoType, HttpSession session) {
        FlightsEntity entity = new FlightsEntity();
        entity.setStartPlanetName(firstPlanet);
        entity.setFinishPlanetName(secondPlanet);
        entity.setCargoType(cargoType);
        entity.setDateOfFlight(new java.sql.Date(System.currentTimeMillis()+10*60*60*24*1000));
        entity.setShipId(1);
        entity.setWeight(Integer.parseInt(weight));
        entity.setClientId((int)session.getAttribute("id"));
        flightRepository.save(entity);


        String response = sendMessage("https://api.telegram.org/bot514138986:AAF2kYca0JIvPabh5xaOUxqbxJFMfKHd8UQ/getUpdates");
        PeopleEntity peopleEntity = peopleRepository.findById((int)session.getAttribute("id"));
        int id=-1;
        if((response.lastIndexOf(",\"first_name\":\""+peopleEntity.getName()+"\",\"last_name\":\""+peopleEntity.getSurname()+"\""))!=-1){
            int k = response.lastIndexOf(",\"first_name\":\""+peopleEntity.getName()+"\",\"last_name\":\""+peopleEntity.getSurname()+"\"");
            System.out.println(k);
            String line = response.substring(0,k);
            k = line.lastIndexOf("\"id\":") + 5;
            id = Integer.parseInt(line.substring(k));
        }
        if(id!=-1) {
            String resp = sendMessage("https://api.telegram.org/bot514138986:AAF2kYca0JIvPabh5xaOUxqbxJFMfKHd8UQ/sendMessage?chat_id=" + id + "&text=Information%20about%20your%20order:%20start%20planet:%20" + firstPlanet +
                    ";%20destination%20planet:%20" + secondPlanet + ";delivery%20type:%20" + cargoType + ";weight:%20" + weight);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/#/orders");
        return modelAndView;
    }
    @RequestMapping(value = "/calculateCost", method = RequestMethod.GET)
    public @ResponseBody
    String calculateCost(@RequestParam String firstPlanet
            , @RequestParam String secondPlanet, @RequestParam String weight
            , @RequestParam String cargoType) {
        PlanetsEntity startplanet = planetRepository.findByName(firstPlanet);
        PlanetsEntity finishPlanet = planetRepository.findByName(secondPlanet);
        FlightsEntity flightsEntity = new FlightsEntity();
        flightsEntity.setStartPlanetName(firstPlanet);
        flightsEntity.setFinishPlanetName(secondPlanet);
        flightsEntity.setCargoType(cargoType);
        flightsEntity.setWeight(Integer.parseInt(weight));
        return "$"+String.valueOf(getCost(flightsEntity,startplanet,finishPlanet));
    }
    public double getCost(FlightsEntity flightsEntity, PlanetsEntity startPlanet, PlanetsEntity finishPlanet){
        int param = 0;
        switch (flightsEntity.getCargoType()){
            case "default": param=10;break;
            case "fast": param=20;break;
            case "safe": param=15;break;
            case "premium": param=25; break;
        }

        double  cost = Math.sqrt((Math.pow((double)(startPlanet.getCoordX()-finishPlanet.getCoordX()),2)+
                Math.pow((double)(startPlanet.getCoordY()-finishPlanet.getCoordY()),2)+
                Math.pow((double)(startPlanet.getCoordZ()-finishPlanet.getCoordZ()),2)));
        cost*=flightsEntity.getWeight();
        return cost;
    }


    @RequestMapping(value = "getAllEvents")
    public @ResponseBody String getAllEvents(){
        String response = sendMessage("http://localhost:8080/getAllEvents");
        System.out.println(response);
        return response;
    }

    private String sendMessage(String url){
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();

        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

}