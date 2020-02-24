
package ir.ariaman.ariakala.model.jsonschema.category;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    @Expose
    private List<Self> self = null;
    @SerializedName("collection")
    @Expose
    private List<Collection> collection = null;
    @SerializedName("up")
    @Expose
    private List<Up> up = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links() {
    }

    /**
     * 
     * @param self
     * @param collection
     * @param up
     */
    public Links(List<Self> self, List<Collection> collection, List<Up> up) {
        super();
        this.self = self;
        this.collection = collection;
        this.up = up;
    }

    public List<Self> getSelf() {
        return self;
    }

    public void setSelf(List<Self> self) {
        this.self = self;
    }

    public List<Collection> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection> collection) {
        this.collection = collection;
    }

    public List<Up> getUp() {
        return up;
    }

    public void setUp(List<Up> up) {
        this.up = up;
    }

}
