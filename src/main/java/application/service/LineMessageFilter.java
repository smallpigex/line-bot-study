package application.service;

import application.model.Keyword;

public class LineMessageFilter {
  private boolean isRightKey(String text) {
    return text.matches("^餓惹 .*");
  }
  
  private boolean isRightLength(String[] text) {
    return 4 == text.length;
  }
  
  private boolean isFloat(String number) {
    return number.matches("\\d*\\.?\\d*");
  }
  
  public Keyword grepKey(String text) {
    Keyword key = new Keyword();
    if(!isRightKey(text)) return key;
    String[] split = text.split(" ");
    if(!isRightLength(split)) return key;
    float rate = 4.0f; 
    if(isFloat(split[3])) {
      rate = Float.parseFloat(split[3]);
    }
    key.setPlace(split[1]);
    key.setType(split[2]);
    key.setRating(rate);
    key.setNull(false);
    return key;
  }
}
