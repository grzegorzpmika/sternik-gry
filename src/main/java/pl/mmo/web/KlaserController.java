package pl.mmo.web;

import pl.mmo.entities.Gra;
import pl.mmo.services.KlaserService;
import pl.mmo.services.NotificationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class KlaserController {

    @Autowired
    private KlaserService klaserService;

    @Autowired
    private NotificationService notificationService;

    @ModelAttribute("gryWszystkie")
    public List<Gra> populateCoins() {
        return this.klaserService.findAll();
    }


    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/gry", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        model.addAttribute("MyMessages", NotificationService.getNotificationMessages());
        return "klaser";
    }

    @RequestMapping("/wypozycz")
    public String showToBorrowPage() {
        return "wypozycz";
    }

}