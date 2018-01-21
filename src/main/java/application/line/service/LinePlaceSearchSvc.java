package application.line.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linecorp.bot.model.message.template.Template;
import application.model.Keyword;
import application.model.Place;
import application.service.PlaceService;
import application.service.line.template.LineCarouselColumn;

@Service
public class LinePlaceSearchSvc {
  @Autowired
  LineCarouselColumn lineCarouselColumn;
  
  @Autowired
  PlaceService placeService;
  
  public Template getPlaceTemplate(Keyword keyword) {
    List<Place> places = placeService.find(keyword);
    return lineCarouselColumn.createLineTemplate(places);
  }

}
