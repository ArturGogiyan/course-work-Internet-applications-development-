package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import test.entities.AtmosphereEntity;
import test.entities.PeopleEntity;
import test.entities.PlanetsEntity;
import test.entities.RolesEntity;
import test.repository.AtmosphereRepository;
import test.repository.PeopleRepository;
import test.repository.PlanetRepository;
import test.repository.RolesRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

@Controller
@RestController
public class MainController {
	@Autowired
	private AtmosphereRepository atmosphereRepository;
	@Autowired
	private PlanetRepository planetRepository;
	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private PeopleRepository peopleRepository;



	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test() {
		System.out.println("here");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("test.html");
		return modelAndView;
	}

	@RequestMapping(value = "/autentification", method = RequestMethod.GET)
	public ModelAndView autentification() {
		System.out.println("autentification");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("autentification.html");
		return modelAndView;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employee() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employee.html");
		return modelAndView;
	}
	@RequestMapping(value = "/priceList", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView priceList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("priceList.html");
		return modelAndView;
	}
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView signUp() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signUp.html");
		return modelAndView;
	}
	@RequestMapping(value = "/AccessDeniedPage", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("403.html");
		return modelAndView;
	}
	@RequestMapping(value = "/allAtm", method = RequestMethod.GET)
	public @ResponseBody String allAtm (){
		return atmosphereRepository.findAll().toString();
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser (@RequestParam String name
			, @RequestParam String surname,@RequestParam String login
			,@RequestParam String password,@RequestParam String bday){
		PeopleEntity peopleEntity = new PeopleEntity();
		peopleEntity.setName(name);
		peopleEntity.setEnabled((byte)1);
		peopleEntity.setPassword(password);
		peopleEntity.setUserName(login);
		peopleEntity.setSurname(surname);
		int year = Integer.parseInt(bday.substring(0,4));
		int month = Integer.parseInt(bday.substring(5,7));

		int day = Integer.parseInt(bday.substring(8));
		long time = ((year-1970)*365+getMonthDays(month,year)+day)*24*60*60;
		time *=1000;
		peopleEntity.setBirthdayDate(new Date(time));
		ModelAndView modelAndView = new ModelAndView();
		RolesEntity rolesEntity = new RolesEntity();
		rolesEntity.setUserName(login);
		rolesEntity.setRoleName("ROLE_USER");
		rolesRepository.save(rolesEntity);
		peopleRepository.save(peopleEntity);
		modelAndView.setViewName("redirect:/#/autentification");
		return modelAndView;
	}
	private int getMonthDays(int month, int year) {
		int summ = 0;
		for (int i = 1; i < month; i++) {
			if(i==1 || i==3||i==5 || i==7 || i==8 || i==10 || i==12)summ+=31;
			else if(i==2 && year%4==0) summ+=29;
			else if(i==2)summ+=28;
			else summ+=30;
		}
		summ+=(year-1970)/4;
		if((year)%4!=0)summ-=1;
		return  summ;
	}
}