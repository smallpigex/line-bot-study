package application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("app")
public class AppConfig {
  
  private String zhTW;

  public String getZhTW() {
    return zhTW;
  }

  public void setZhTW(String zhTW) {
    this.zhTW = zhTW;
  }
  
}
