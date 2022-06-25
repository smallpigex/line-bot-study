package application.config.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.maps.GeoApiContext;
import application.config.GoogleConfig;

@Configuration
public class GeoApiContextConfig {
  
  @Autowired
  private GoogleConfig config;
  
  @Bean
  public GeoApiContext getGeoApiContextBean() {
    return new GeoApiContext.Builder()
            .apiKey(config.getApikey())
            .build();
  }

}
