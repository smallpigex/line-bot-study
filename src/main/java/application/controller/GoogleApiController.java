package application.controller;

import java.util.List;
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
    
    @RequestMapping(value = "/search")
    public @ResponseBody List<Place> search (@RequestBody Keyword place) { 
        foodService.find(place);
        return foodService.find(place);
    }
}
