package com.detroitlabs.giflibrary.controller;

import com.detroitlabs.giflibrary.data.GifRepository;
import com.detroitlabs.giflibrary.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Locale;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;


    @RequestMapping("/")

    public String displayGifs() {
        return "home";
    }


    @RequestMapping("/gif/{name}")

    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        String concatName = gif.getUsername().toLowerCase().replace(" ", "");
        modelMap.put("gif", gif);
        modelMap.put("concatName", concatName);
        return "gif-details";
    }


//    @RequestMapping("/gif/{dateUploaded}")
//
//    public String gifDateUploaded(@PathVariable LocalDate dateUploaded, ModelMap modelMap) {
//        Gif gifDateUploaded = gifRepository.findByDateUploaded(dateUploaded);
//        modelMap.put("gifDateUploaded", gifDateUploaded);
//        return "gif-details";
//    }
//
//    @RequestMapping("/gif/{username}")
//
//    public String gifUsername(@PathVariable String username, ModelMap modelMap) {
//        Gif gifUsername = gifRepository.findByUsername(username);
//        modelMap.put("gifUsername", gifUsername);
//        return "gif-details";
//    }
    //we use ModelMap's put() method to add our new instance of GIF to the map, and give it a key of "gif"
}
