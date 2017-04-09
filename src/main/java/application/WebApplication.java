package application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.action.Action;
import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

import application.model.Keyword;
import application.model.Place;
import application.service.PlaceService;

@SpringBootApplication
@LineMessageHandler
public class WebApplication {
    @Autowired 
    PlaceService  service;
	public static void main(String args[]) {
		SpringApplication.run(WebApplication.class, args);
	}
	
	@EventMapping
    public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
	    
        System.out.println("event: " + event);
        String text = event.getMessage().getText();
        String[] textArray = text.split(" ");
        if(textArray.length == 4 && textArray[1].equals("餓惹")) {
            Keyword keyord = new Keyword();
            keyord.setPlace(textArray[1]);
            keyord.setType(textArray[2]);
            if(textArray.length >= 3 && textArray[3] != null) {
                try {
                    keyord.setRating(Float.valueOf(textArray[3]));                                
                } catch (NumberFormatException e) {
                    keyord.setRating(4.0f);
                }
                List<Place> places = service.find(keyord);
                 
                List<CarouselColumn> columns = new ArrayList<CarouselColumn>();   
                for(Place place : places) {
                    List<Action> actions = new ArrayList<Action>();
                    URIAction uriAction = new URIAction("abc", place.getGoogleMapUrl());
                    actions.add(uriAction);
                    CarouselColumn column = new CarouselColumn("", place.getName(), place.getName(), actions);
                    columns.add(column);
                }
                CarouselTemplate template = new CarouselTemplate(columns);
                
                TemplateMessage templateMsg = new TemplateMessage("Result", template);
                return templateMsg;
            }
        }
        return new TextMessage("勿擾");
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
	
}
