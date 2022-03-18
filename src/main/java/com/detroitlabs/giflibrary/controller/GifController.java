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
        modelMap.put("gif", gif);
        return "gif-details";
    }

//
//    @RequestMapping("/gif/{dateUploaded}")
//
//    public String gifDetails(@PathVariable LocalDate dateUploaded, ModelMap modelMap) {
//        Gif gif = gifRepository.findByDateUploaded(dateUploaded);
//        modelMap.put("gif", gif);
//        return "gif-details";
//    }
//
//    @RequestMapping("/gif/{username}")
//
//    public String gifDetails2(@PathVariable String username, ModelMap modelMap) {
//        Gif gif = gifRepository.findByUsername(username);
//        modelMap.put("gif", gif);
//        return "gif-details";
//    }
    //we use ModelMap's put() method to add our new instance of GIF to the map, and give it a key of "gif"
}
