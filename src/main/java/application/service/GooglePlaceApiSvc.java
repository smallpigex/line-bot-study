package application.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.PlacesApi;
import com.google.maps.TextSearchRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import application.config.AppConfig;

@Service
public class GooglePlaceApiSvc {
  
  @Autowired
  GeoApiContext geoApiContext;
  
  @Autowired
  AppConfig appConfig;
  
  public PlacesSearchResponse nearbySearchQueryAwait(LatLng latLng, String keyword, int radius) {
    try {
      return nearbySearchQuery(latLng).keyword(keyword).radius(500).await();
    } catch (ApiException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
    
  }
  public NearbySearchRequest nearbySearchQuery(LatLng latLng) {
    NearbySearchRequest nearbySearchRequest = PlacesApi.nearbySearchQuery(geoApiContext, latLng);
    return nearbySearchRequest;
  } 
  
  
  public PlaceDetails placeDetailsAwait(String placeId) {
    try {
      return placeDetails(placeId).language(appConfig.getZhTW()).await();
    } catch (ApiException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
  public PlaceDetailsRequest placeDetails(String placeId) {
    PlaceDetailsRequest placeDetailsRequest = PlacesApi.placeDetails(geoApiContext, placeId);
    return placeDetailsRequest;
  }
  
  
  public PlacesSearchResponse textSearchQueryAwait(String query) {
    try {
      return textSearchQuery(query).language(appConfig.getZhTW()).await();
    } catch (ApiException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
  
  public TextSearchRequest textSearchQuery(String query) {
    TextSearchRequest textSearchRequest = PlacesApi.textSearchQuery(geoApiContext, query);
    return textSearchRequest;
  }
  
  public TextSearchRequest language(TextSearchRequest textSearchQuery, String language) {
    return textSearchQuery.language(language);
  }
  

}
