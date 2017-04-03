package application.controller;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import application.model.Keyword;
import application.model.Place;
import application.service.PlaceService;

@Controller
public class GoogleApiController {
	
    @Autowired
    private PlaceService foodService;
    
    @RequestMapping(value = "/mapApi")
    public @ResponseBody List<Place> mapApi (@RequestBody Keyword place) throws JSONException {  
        foodService.find(place);
        System.out.println(place.getPlace());
        return foodService.find(place);
    }
}
