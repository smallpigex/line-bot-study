package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import application.model.Keyword;
import application.service.LineMessageFilter;
import application.service.line.LinePlaceSearchSvc;

@SpringBootApplication
@LineMessageHandler
public class WebApplication {
  @Autowired
  LinePlaceSearchSvc linePlaceSearchSvc;

  public static void main(String args[]) {
    SpringApplication.run(WebApplication.class, args);
  }

  @EventMapping
  public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) {

    String text = event.getMessage().getText();
    LineMessageFilter filter = new LineMessageFilter();
    Keyword keyword = filter.filtKey(text);
    if(keyword.isNull()) {
      return new TextMessage(text);
    }
    TemplateMessage templateMsg = new TemplateMessage("Result", linePlaceSearchSvc.getPlaceTemplate(keyword));
    return templateMsg;
  }

  @EventMapping
  public void handleDefaultMessageEvent(Event event) {
    System.out.println("event: " + event);
  }

}
