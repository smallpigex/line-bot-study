package application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("google")
public class GoogleConfig {
  
    private String apikey ;
    private String photoTest;

    public String getPhotoTest() {
        return photoTest;
    }
    public void setPhotoTest(String photoTest) {
        this.photoTest = photoTest;
    }
    public GoogleConfig() {
    }
    public String getApikey() {
      return apikey;
    }
    public void setApikey(String apikey) {
      this.apikey = apikey;
    }

}
