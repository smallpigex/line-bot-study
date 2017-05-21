package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import application.config.Config;
import application.model.Keyword;
import application.model.Place;
import application.service.PlaceService;

@Controller
public class GoogleApiController {
	
    @Autowired
    private PlaceService foodService;
    @Autowired
    private Config config;
    
    
    @RequestMapping(value = "/search")
    public @ResponseBody List<Place> search (@RequestBody Keyword place) throws JSONException {  
        foodService.find(place);
        return foodService.find(place);
    }
}
