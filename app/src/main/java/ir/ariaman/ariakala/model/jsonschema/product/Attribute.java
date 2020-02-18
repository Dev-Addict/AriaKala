
package ir.ariaman.ariakala.model.jsonschema.product;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attribute {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("visible")
    @Expose
    private Boolean visible;
    @SerializedName("variation")
    @Expose
    private Boolean variation;
    @SerializedName("options")
    @Expose
    private List<String> options = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Attribute() {
    }

    /**
     *
     * @param visible
     * @param name
     * @param options
     * @param id
     * @param position
     * @param variation
     */
    public Attribute(Integer id, String name, Integer position, Boolean visible, Boolean variation, List<String> options) {
        super();
        this.id = id;
        this.name = name;
        this.position = position;
        this.visible = visible;
        this.variation = variation;
        this.options = options;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Attribute withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attribute withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Attribute withPosition(Integer position) {
        this.position = position;
        return this;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Attribute withVisible(Boolean visible) {
        this.visible = visible;
        return this;
    }

    public Boolean getVariation() {
        return variation;
    }

    public void setVariation(Boolean variation) {
        this.variation = variation;
    }

    public Attribute withVariation(Boolean variation) {
        this.variation = variation;
        return this;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Attribute withOptions(List<String> options) {
        this.options = options;
        return this;
    }

}