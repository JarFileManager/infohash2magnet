package com.infohash2magnet.converterApp.controllers;


import com.infohash2magnet.converterApp.services.ConverterService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    private ConverterService converterService;

    @RequestMapping("/")
    public String home(HttpSession httpSession, Model model){
        String magnetLink = (String) httpSession.getAttribute("magnetLink");
        model.addAttribute("magnetLink", magnetLink);

        return "index.html";
    }

    @RequestMapping("/convert")
    public String convertInfoHashToMagnet(@RequestParam String infoHash, HttpSession httpSession){
        String magnetLink = converterService.convertInfoHashToMagnet(infoHash);
        httpSession.setAttribute("magnetLink", magnetLink);

        return "redirect:/";
    }

}
