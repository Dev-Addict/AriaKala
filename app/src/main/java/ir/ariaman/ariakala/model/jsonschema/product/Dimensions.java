
package ir.ariaman.ariakala.model.jsonschema.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dimensions {

    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;

    /**
     * No args constructor for use in serialization
     *
     */
    public Dimensions() {
    }

    /**
     *
     * @param length
     * @param width
     * @param height
     */
    public Dimensions(String length, String width, String height) {
        super();
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Dimensions withLength(String length) {
        this.length = length;
        return this;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Dimensions withWidth(String width) {
        this.width = width;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Dimensions withHeight(String height) {
        this.height = height;
        return this;
    }

}