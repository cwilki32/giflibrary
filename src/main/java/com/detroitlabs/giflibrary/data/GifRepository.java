package com.detroitlabs.giflibrary.data;

import com.detroitlabs.giflibrary.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("toobad", LocalDate.of(2019, 2, 23), "Erika Languirand", true, 1),
            new Gif("exhausting", LocalDate.of(2019, 2, 23), "Jen Bloomer", false, 2),
            new Gif("headtilt", LocalDate.of(2019, 2, 23), "Dan Newport", true, 3),
            new Gif("corgibeg", LocalDate.of(2019, 2, 23), "Matt of Lansing", false, 3),
            new Gif("hugemistake", LocalDate.of(2019, 2, 23), "Erika Languirand", true, 1),
            new Gif("whatisaid", LocalDate.of(2019, 2, 23), "Dan Newport", true, 2),
            new Gif("confuseddog", LocalDate.of(2022, 3, 18), "Collin Wilkins", true, 3),
            new Gif("leo", LocalDate.of(2022, 3, 18), "Collin Wilkins", false, 1),
            new Gif("thatswhatshesaid", LocalDate.of(2022, 3, 18), "Collin Wilkins", true, 1));


    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> findById(int id) { //32.3 add a method to GifRepository that allows you to retrieve a gif by id
        List<Gif> gifsByCategory = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.getId() == id) {
                gifsByCategory.add(gif);
            }
        }
        return gifsByCategory;

    }
    //exercise 32.5 bullet 1
    public List<Gif> findByQuery(String keyword) { //method that can return all Gif objects whose name contains a specified String
        List <Gif> gifsByQuery = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().contains(keyword)) {
                gifsByQuery.add(gif);
            }
        } return gifsByQuery;
    }
}


