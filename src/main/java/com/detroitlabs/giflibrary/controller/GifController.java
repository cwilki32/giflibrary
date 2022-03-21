package com.detroitlabs.giflibrary.controller;

import com.detroitlabs.giflibrary.data.GifRepository;
import com.detroitlabs.giflibrary.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String displayGifs() {
        return "home";
    }

    //attempting to add favorites page
    @RequestMapping("/favorites")
    public String displayFavorites(ModelMap modelMap) {
        List<Gif> favoriteGifs = gifRepository.showFavorites();
        modelMap.put("favoriteGifs", favoriteGifs);
        return "favorites";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        String concatName = gif.getUsername().toLowerCase().replace(" ", "");
        modelMap.put("gif", gif);
        modelMap.put("concatName", concatName);
        return "gif-details";
    }
    //we use ModelMap's put() method to add our new instance of GIF to the map, and give it a key of "gif"

    //exercise 32.5 bullet 2 and 3 -- @RequestParam that intercepts the URI specified by search form's action attribute

    @RequestMapping("/search")
    public String gifQuery(@RequestParam String keyword, ModelMap modelMap) {
        if (keyword != null) {
            List<Gif> gifQuery = gifRepository.findByQuery(keyword);//searches all gifs to return by keyword
            modelMap.put("gifQuery", gifQuery);
            return "searchresults";
        } else {
            return "home";
        }
    }
}


