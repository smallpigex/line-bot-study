package application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("key")
public class Config {
    private String googlekey = System.getenv("googlekey");
    private String photoTest;

    public String getPhotoTest() {
        return photoTest;
    }

    public void setPhotoTest(String photoTest) {
        this.photoTest = photoTest;
    }

    public Config() {
    }

    public String getGooglekey() {
        return googlekey;
    }

    public void setGooglekey(String googlekey) {
        this.googlekey = googlekey;
    }

}
