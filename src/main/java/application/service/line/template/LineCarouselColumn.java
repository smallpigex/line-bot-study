package application.service.line.template;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.linecorp.bot.model.action.Action;
import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import application.model.Place;

@Service
public class LineCarouselColumn implements LineTemplate {
    public CarouselTemplate createLineTemplate(List<Place> places) {
        List<CarouselColumn> columns = new ArrayList<CarouselColumn>();
        for (Place place : places) {
            List<Action> actions = new ArrayList<Action>();
            URI googleMapURI = URI.create(place.getGoogleMapUrl());
            URIAction uriAction = new URIAction("Open Google Map", googleMapURI, null);
            actions.add(uriAction);
            URI uri = URI.create(place.getPhoto());

            CarouselColumn column =
                    new CarouselColumn(uri, place.getName(), place.getAddress(), actions);
            columns.add(column);
        }
        return new CarouselTemplate(columns);
    }
}
