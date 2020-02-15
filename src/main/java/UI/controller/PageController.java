package UI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @RequestMapping(value = "/floor1", method = RequestMethod.GET)
    public String Floor1(String floor1, Model model) {
        model.addAttribute("floor1", floor1);

        return "floor1";
    }

    @RequestMapping(value = "/floor3", method = RequestMethod.GET)
    public String Floor3(String floor3, Model model) {
        model.addAttribute("floor3", floor3);

        return "floor3";
    }

    @RequestMapping(value = "/room106", method = RequestMethod.GET)
    public String Room106(String room106, Model model) {
        model.addAttribute("room106", room106);

        return "room106";
    }

    @RequestMapping(value = "/room106ant", method = RequestMethod.GET)
    public String Room106Ant(String room106ant, Model model) {
        model.addAttribute("room106ant", room106ant);

        return "room106ant";
    }
}
