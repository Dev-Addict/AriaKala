
package ir.ariaman.ariakala.model.jsonschema.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collection {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Collection() {
    }

    /**
     * 
     * @param href
     */
    public Collection(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
