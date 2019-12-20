
package ir.ariaman.ariakala.model.jsonschema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("value")
    @Expose
    private String value;

    /**
     * No args constructor for use in serialization
     *
     */
    public MetaDatum() {
    }

    /**
     *
     * @param id
     * @param value
     * @param key
     */
    public MetaDatum(Integer id, String key, String value) {
        super();
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MetaDatum withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public MetaDatum withKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MetaDatum withValue(String value) {
        this.value = value;
        return this;
    }

}