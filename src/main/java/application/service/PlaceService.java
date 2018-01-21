package application.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import application.model.Keyword;
import application.model.Place;
import application.service.place.PlaceGenerator;

@Service
public class PlaceService {

  @Autowired
  GooglePlaceApiSvc googlePlaceApiSvc;
  
  @Autowired
  PlaceGenerator placeGnerator;

  public List<Place> find(Keyword keyword) {
    PlacesSearchResponse res;
    if (!keyword.getLocation().isEmpty()) {
      LatLng latLng = new LatLng(Double.valueOf(keyword.getLatitude()),
          Double.valueOf(keyword.getLongtitude()));
      res = googlePlaceApiSvc.nearbySearchQueryAwait(latLng, keyword.getType(), 500);
    } else {
      String query = keyword.getType() + " " + keyword.getPlace();
      res = googlePlaceApiSvc.textSearchQueryAwait(query);
    }
    return processResponse(res, keyword.getRating(), 1);
  }

  private List<Place> processResponse(PlacesSearchResponse res, float rating, int numberOfStore) {
    List<Place> places = new ArrayList<Place>();
    PlacesSearchResult[] list = res.results;
    int count = 0;
    for (PlacesSearchResult result : list) {
      if (result.rating >= rating && count != numberOfStore) {
        PlaceDetails pd = googlePlaceApiSvc.placeDetailsAwait(result.placeId);
        places.add(placeGnerator.createPlace(result, pd));
        count++;
      }
    }
    return places;
  }
}
