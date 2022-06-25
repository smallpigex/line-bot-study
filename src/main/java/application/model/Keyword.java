package application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Keyword {

    private String placeID = "";

    private String latitude = ""; // 緯度
    private String longitude = ""; // 經度
    private String location = "";
    private String place = "";
    private String type = "";
    private float rating = 4.0f;
    private int number = 5;
    private boolean isNull = true;

}
