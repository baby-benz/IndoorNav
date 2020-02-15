package UI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainForm(@RequestParam(name = "name", required = false, defaultValue = "World") String test, Model model) {
        model.addAttribute("test", test);
        return "test";    }

}