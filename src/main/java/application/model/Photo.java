package application.model;

public class Photo {
    private String width;
    private String height;
    private String photo_reference;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }

    public String getHeight() {
        return height;
    }

    public String getPhoto_reference() {
        return photo_reference;
    }

}
