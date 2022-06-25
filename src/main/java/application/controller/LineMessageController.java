package application.controller;

import application.model.Keyword;
import application.service.LineMessageFilter;
import application.service.line.LinePlaceSearchSvc;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@LineMessageHandler
public class LineMessageController {

    @Autowired
    private LinePlaceSearchSvc linePlaceSearchSvc;

    @EventMapping
    public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) {

        String text = event.getMessage().getText();
        LineMessageFilter filter = new LineMessageFilter();
        Keyword keyword = filter.grepKey(text);
        if (keyword.isNull()) {
            return new TextMessage(text);
        }
        return new TemplateMessage("Result", linePlaceSearchSvc.getPlaceTemplate(keyword));
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }

}
