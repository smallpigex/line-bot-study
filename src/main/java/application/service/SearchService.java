package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.JSONPObject;

@Service
public class SearchService {
    
    @Autowired
    private GoogleService googleService;
    
    @Autowired
    private PlaceService foodService;
    
    public JSONPObject findRestaurant(String info) {
        
        return null;
    }
}
