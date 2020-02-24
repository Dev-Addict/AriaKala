
package ir.ariaman.ariakala.model.jsonschema.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Up {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Up() {
    }

    /**
     * 
     * @param href
     */
    public Up(String href) {
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
