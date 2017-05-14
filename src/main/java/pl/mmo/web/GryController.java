package pl.mmo.web;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.mmo.entities.Gra;
import pl.mmo.entities.Status;
import pl.mmo.services.KlaserService;
import pl.mmo.services.NotificationService;

@Controller
public class GryController {

    @Autowired
    // @Qualifier("spring")
    private KlaserService klaserService;

    @Autowired
    private NotificationService notifyService;

    @ModelAttribute("statusyAll")
    public List<Status> populateStatusy() {
        return Arrays.asList(Status.ALL);
    }

    @RequestMapping(value = "/gry/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id, final ModelMap model) {
        Optional<Gra> result;
        result = klaserService.findById(id);
        if (result.isPresent()) {
            Gra gra = result.get();
            model.addAttribute("gra", gra);
            return "gra";
        } else {
            notifyService.addErrorMessage("Nie można znaleźć gryS o id: #" + id);
            model.clear();
            return "redirect:/gry";
        }
    }

    @RequestMapping(value = "/gry/{id}/json", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Gra> viewAsJson(@PathVariable("id") Long id, final ModelMap model) {
        Optional<Gra> result;
        result = klaserService.findById(id);
        if (result.isPresent()) {
            Gra gra = result.get();
            return new ResponseEntity<Gra>(gra, HttpStatus.OK);
        } else {
            notifyService.addErrorMessage("Cannot find games #" + id);
            model.clear();
            return new ResponseEntity<Gra>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/gry", params = { "save" }, method = RequestMethod.POST)
    public String saveGame(Gra gra, BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "gra";
        }
        Optional<Gra> result = klaserService.edit(gra);
        if (result.isPresent())
            notifyService.addInfoMessage("Zapis udany");
        else
            notifyService.addErrorMessage("Zapis nie udany");
        model.clear();
        return "redirect:/gry";
    }

    @RequestMapping(value = "/gry", params = { "create" }, method = RequestMethod.POST)
    public String createMovie(Gra Gra, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "gra";
        }
        klaserService.create(Gra);
        model.clear();
        notifyService.addInfoMessage("Zapis nowej udany");
        return "redirect:/gry";
    }

    @RequestMapping(value = "/gry", params = { "remove" }, method = RequestMethod.POST)
    public String removeRow(final Gra gra, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("remove"));
        Optional<Boolean> result = klaserService.deleteById(rowId.longValue());
        return "redirect:/gry";
    }

    @RequestMapping(value = "/gry/create", method = RequestMethod.GET)
    public String showMainPages(final Gra gra) {
        gra.setDataDodaniaGry(Calendar.getInstance().getTime());
        return "gra";
    }
}