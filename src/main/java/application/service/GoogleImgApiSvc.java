package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.config.GoogleConfig;

@Service
public class GoogleImgApiSvc {
  @Autowired
  private GoogleConfig googleConfig;


  public String getGoogleImgURL(int w, int h, String reference) {
    return String.format(
        "https://maps.googleapis.com/maps/api/place/photo?maxwidth=%d&maxheight=%d&photoreference=%s&key=%s",
        new Object[] {w, h, reference, googleConfig.getApikey()});
  }

}
