package application.model;

import org.springframework.stereotype.Component;

@Component
public class Keyword {

    private String placeID = "";


    private String location = "";
    private String place = "";
    private String type = "";
    private float rating = 0.0f;

    public String getPlaceID() {
        return placeID;
    }
    
    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}
