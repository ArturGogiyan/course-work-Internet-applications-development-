package test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RestController
public class StartPageController {
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody String main(HttpSession session) {
        String order ="<!DOCTYPE html>\n" +
                "<html lang=\"en\" ng-app='app'\n" +
                "      xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
                "\n" +
                "      xmlns:sec=\"http://www.thymeleaf.org/thymeleaf-extras-springsecurity3\"\n" +
                "      xmlns:layout=\"http://www.ultraq.net.nz/thymeleaf/layout\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "  <meta name=\"generator\" content=\"Mobirise v4.4.1, mobirise.com\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "  <link rel=\"shortcut icon\" href=\"assets/images/mbr-favicon.png\" type=\"image/x-icon\">\n" +
                "  <meta name=\"description\" content=\"\">\n" +
                "  <title>Home</title>\n" +
                "\n" +
                "  <link rel=\"stylesheet\" href=\"assets/web/assets/mobirise-icons/mobirise-icons.css\">\n" +
                "  <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\n" +
                "  <link rel=\"stylesheet\" href=\"assets/soundcloud-plugin/style.css\">\n" +
                "  <link rel=\"stylesheet\" href=\"assets/mobirise/css/style.css\">\n" +
                "  <link rel=\"stylesheet\" href=\"assets/mobirise-slider/style.css\">\n" +
                "  <link rel=\"stylesheet\" href=\"assets/custom/style.css\">\n" +
                "  <link rel=\"stylesheet\" href=\"assets/mobirise/css/mbr-additional.css\" type=\"text/css\">\n" +
                "\n" +
                "\n" +
                "\n" +
                "</head>\n" +
                "<body class=\"bodyy\">\n" +
                "<section class=\"mbr-navbar mbr-navbar--freeze mbr-navbar--absolute mbr-navbar--sticky mbr-navbar--auto-collapse\" id=\"ext_menu-c\" data-rv-view=\"2\">\n" +
                "  <div class=\"mbr-navbar__section mbr-section\">\n" +
                "    <div class=\"mbr-section__container container\">\n" +
                "      <div class=\"mbr-navbar__container\">\n" +
                "        <div class=\"mbr-navbar__column mbr-navbar__column--s mbr-navbar__brand\">\n" +
                "                    <span class=\"mbr-navbar__brand-link mbr-brand mbr-brand--inline\">\n" +
                "                        <span class=\"mbr-brand__logo\"><a href=\"https://mobirise.com\" class=\"mbri-sad-face mbr-iconfont mbr-iconfont-menu\"></a></span>\n" +
                "                        <span class=\"mbr-brand__name\"><a class=\"mbr-brand__name text-white\" href=\"https://vk.com/edvanchi\">Gogian Artur</a></span>\n" +
                "                    </span>\n" +
                "        </div>\n" +
                "        <div class=\"mbr-navbar__hamburger mbr-hamburger\"><span class=\"mbr-hamburger__line\"></span></div>\n" +
                "        <div class=\"mbr-navbar__column mbr-navbar__menu\">\n" +
                "          <nav class=\"mbr-navbar__menu-box mbr-navbar__menu-box--inline-right\">\n" +
                "            <div class=\"mbr-navbar__column\">\n" +
                "              <ul class=\"mbr-navbar__items mbr-navbar__items--right float-left mbr-buttons mbr-buttons--freeze mbr-buttons--right btn-decorator mbr-buttons--active\">\n" +
                "                <li class=\"mbr-navbar__item\"><a class=\"mbr-buttons__link btn text-white\" href=\"#/\">Main</a></li>\n" +
                "                <li class=\"mbr-navbar__item\"><a class=\"mbr-buttons__link btn text-white\" href=\"#/orders\">Orders</a></li>\n" +
                "                <li class=\"mbr-navbar__item\"><a class=\"mbr-buttons__link btn text-white\" href=\"#/planetBase\">Base of Planets</a></li>\n" +
                "                <li class=\"mbr-navbar__item\"><a class=\"mbr-buttons__link btn text-white\" href=\"#/priceList\">price-list</a></li>\n" +
                "                <li class=\"mbr-navbar__item\"><a class=\"mbr-buttons__link btn text-white\" href=\"#/employee\">Employment</a></li>\n";
        if(session.getAttribute("ROLE_ADMIN")!= null || session.getAttribute("ROLE_WORKER")!=null)order = order.concat( "                <li class=\"mbr-navbar__item\"><a class=\"mbr-buttons__link btn text-white\" href=\"/workerPage\">for employees</a></li>\n");
        order = order.concat("              </ul>\n" +
                "              <ul class=\"mbr-navbar__items mbr-navbar__items--right mbr-buttons mbr-buttons--freeze mbr-buttons--right btn-inverse mbr-buttons--active\"><li class=\"mbr-navbar__item\"><a class=\"mbr-buttons__btn btn btn-danger\" ");

                if(session.getAttribute("ROLE_USER")!=null || session.getAttribute("ROLE_WORKER")!=null || session.getAttribute("ROLE_ADMIN")!=null)order = order.concat("href=\"/logout\">" + "log out");
                else order = order.concat("href=\"#/autentification\">" + "sing in");
                order = order.concat(
                "</a></li></ul>\n" +
                "            </div>\n" +
                "          </nav>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</section>\n" +
                "<!--<form th:action=\"\"></form>-->\n" +
                "<ng-view></ng-view>\n" +
                "<!--<form th:action=\"@{/autentification}\" method=\"post\">-->\n" +
                "  <!--<div><label> User Name : <input type=\"text\" name=\"username\"/> </label></div>-->\n" +
                "  <!--<div><label> Password: <input type=\"password\" name=\"password\"/> </label></div>-->\n" +
                "  <!--<div><input type=\"submit\" value=\"Sign In\"/>    </div>-->\n" +
                "<!--</form>-->\n" +
                "<footer class=\"mbr-section mbr-section--relative mbr-section--fixed-size\" id=\"footer1-b\" data-rv-view=\"0\" style=\"background-color: rgb(0, 0, 0);\">\n" +
                "  <div class=\"mbr-section__container container\">\n" +
                "    <div class=\"mbr-footer mbr-footer--wysiwyg row\" style=\"padding-top: 36.9px; padding-bottom: 36.9px;\">\n" +
                "      <div class=\"col-sm-12\">\n" +
                "        <p class=\"mbr-footer__copyright\">Copyright (c) 2017 Itmo University.</p>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</footer>\n" +
                "<script src=\"assets/web/assets/jquery/jquery.min.js\"></script>\n" +
                "<script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n" +
                "<script src=\"assets/smooth-scroll/smooth-scroll.js\"></script>\n" +
                "<script src=\"assets/bootstrap-carousel-swipe/bootstrap-carousel-swipe.js\"></script>\n" +
                "<script src=\"assets/mobirise/js/script.js\"></script>\n" +
                "<script src=\"assets/custom/script.js\"></script>\n" +
                "\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.3.5/angular.min.js\"></script>\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.3.5/angular-route.js\"></script>\n" +
                "<script src=\"assets/main.js\"></script>\n" +
                "</body>\n" +
                "</html>");
        return order;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
