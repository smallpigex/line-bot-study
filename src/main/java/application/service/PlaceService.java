package application.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

import application.config.Config;
import application.model.Keyword;
import application.model.Place;

@Service
public class PlaceService {
    
    @Autowired
    private Config config;
    
    public List<Place> find(Keyword keyword) {
        List<Place> places = new ArrayList<Place>();
        GeoApiContext context = new GeoApiContext().setApiKey(config.getGooglekey());
        if (!keyword.getLocation().isEmpty()) {
            // run location google API
            PlacesSearchResponse res;
            LatLng latLng = new LatLng(Double.valueOf(keyword.getLatitude()), Double.valueOf(keyword.getLongtitude()));
            try {
                res = PlacesApi.nearbySearchQuery(context, latLng).keyword(keyword.getType()).radius(500).await();
                processResponse(keyword, places, context, res);
            } catch (ApiException | InterruptedException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            // run place search
            // handler keyword
            String query = keyword.getType() + " " + keyword.getPlace();
            PlacesSearchResponse res;
            try {
                res = PlacesApi.textSearchQuery(context, query).language("zh-TW").await();
                processResponse(keyword, places, context, res);
            } catch (ApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }    
        }
        return places;
    }

    private void processResponse(Keyword keyword, List<Place> places, GeoApiContext context, PlacesSearchResponse res)
            throws ApiException, InterruptedException, IOException {
        PlacesSearchResult[] list = res.results;
        for (PlacesSearchResult result : list) {
            if(result.rating >= keyword.getRating()) {
                Place tmp = new Place();
                tmp.setName(result.name);
                tmp.setPlaceId(result.placeId);                        
                tmp.setRating(result.rating);
                PlaceDetails pd = PlacesApi.placeDetails(context, result.placeId).language("zh-TW").await();
                tmp.setGoogleMapUrl(pd.url.toString());
                tmp.setAddress(pd.formattedAddress);
                places.add(tmp);                     
            }
        }
    }
}
