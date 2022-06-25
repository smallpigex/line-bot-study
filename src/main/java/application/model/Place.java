package application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    private String address = "";
    private String placeId = "";
    private String name = "";
    private float rating = 0;
    private String googleMapUrl = "";
    private String photo = "";
    private List<Photo> photos = new ArrayList<Photo>();
}
