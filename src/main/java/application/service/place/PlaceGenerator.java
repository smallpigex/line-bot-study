package application.service.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResult;
import application.model.Place;
import application.service.GoogleImgApiSvc;

@Service
public class PlaceGenerator {
  
  @Autowired
  GoogleImgApiSvc googleImgApiSvc;
  
  public Place createPlace(PlacesSearchResult result, PlaceDetails pd) {
    Place place = new Place();
    place.setName(result.name);
    place.setPlaceId(result.placeId);
    place.setRating(result.rating);
    place.setGoogleMapUrl(pd.url.toString());
    place.setAddress(pd.formattedAddress);
    int w = result.photos[0].width;
    int h = result.photos[0].height;
    String ref = result.photos[0].photoReference;
    place.setPhoto(googleImgApiSvc.getGoogleImgURL(w, h, ref));
    return place;
  }

}
