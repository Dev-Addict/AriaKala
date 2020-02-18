
package ir.ariaman.ariakala.model.jsonschema.product;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_created_gmt")
    @Expose
    private String dateCreatedGmt;
    @SerializedName("date_modified")
    @Expose
    private String dateModified;
    @SerializedName("date_modified_gmt")
    @Expose
    private String dateModifiedGmt;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("featured")
    @Expose
    private Boolean featured;
    @SerializedName("catalog_visibility")
    @Expose
    private String catalogVisibility;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("regular_price")
    @Expose
    private String regularPrice;
    @SerializedName("sale_price")
    @Expose
    private String salePrice;
    @SerializedName("date_on_sale_from")
    @Expose
    private Object dateOnSaleFrom;
    @SerializedName("date_on_sale_from_gmt")
    @Expose
    private Object dateOnSaleFromGmt;
    @SerializedName("date_on_sale_to")
    @Expose
    private Object dateOnSaleTo;
    @SerializedName("date_on_sale_to_gmt")
    @Expose
    private Object dateOnSaleToGmt;
    @SerializedName("price_html")
    @Expose
    private String priceHtml;
    @SerializedName("on_sale")
    @Expose
    private Boolean onSale;
    @SerializedName("purchasable")
    @Expose
    private Boolean purchasable;
    @SerializedName("total_sales")
    @Expose
    private Integer totalSales;
    @SerializedName("virtual")
    @Expose
    private Boolean virtual;
    @SerializedName("downloadable")
    @Expose
    private Boolean downloadable;
    @SerializedName("downloads")
    @Expose
    private List<Object> downloads = null;
    @SerializedName("download_limit")
    @Expose
    private Integer downloadLimit;
    @SerializedName("download_expiry")
    @Expose
    private Integer downloadExpiry;
    @SerializedName("external_url")
    @Expose
    private String externalUrl;
    @SerializedName("button_text")
    @Expose
    private String buttonText;
    @SerializedName("tax_status")
    @Expose
    private String taxStatus;
    @SerializedName("tax_class")
    @Expose
    private String taxClass;
    @SerializedName("manage_stock")
    @Expose
    private Boolean manageStock;
    @SerializedName("stock_quantity")
    @Expose
    private Object stockQuantity;
    @SerializedName("stock_status")
    @Expose
    private String stockStatus;
    @SerializedName("backorders")
    @Expose
    private String backorders;
    @SerializedName("backorders_allowed")
    @Expose
    private Boolean backordersAllowed;
    @SerializedName("backordered")
    @Expose
    private Boolean backordered;
    @SerializedName("sold_individually")
    @Expose
    private Boolean soldIndividually;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("dimensions")
    @Expose
    private Dimensions dimensions;
    @SerializedName("shipping_required")
    @Expose
    private Boolean shippingRequired;
    @SerializedName("shipping_taxable")
    @Expose
    private Boolean shippingTaxable;
    @SerializedName("shipping_class")
    @Expose
    private String shippingClass;
    @SerializedName("shipping_class_id")
    @Expose
    private Integer shippingClassId;
    @SerializedName("reviews_allowed")
    @Expose
    private Boolean reviewsAllowed;
    @SerializedName("average_rating")
    @Expose
    private String averageRating;
    @SerializedName("rating_count")
    @Expose
    private Integer ratingCount;
    @SerializedName("related_ids")
    @Expose
    private List<Integer> relatedIds = null;
    @SerializedName("upsell_ids")
    @Expose
    private List<Object> upsellIds = null;
    @SerializedName("cross_sell_ids")
    @Expose
    private List<Object> crossSellIds = null;
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("purchase_note")
    @Expose
    private String purchaseNote;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    @SerializedName("default_attributes")
    @Expose
    private List<Object> defaultAttributes = null;
    @SerializedName("variations")
    @Expose
    private List<Object> variations = null;
    @SerializedName("grouped_products")
    @Expose
    private List<Object> groupedProducts = null;
    @SerializedName("menu_order")
    @Expose
    private Integer menuOrder;
    @SerializedName("meta_data")
    @Expose
    private List<MetaDatum> metaData = null;
    @SerializedName("_links")
    @Expose
    private Links links;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product() {
    }

    /**
     *
     * @param manageStock
     * @param featured
     * @param purchasable
     * @param purchaseNote
     * @param regularPrice
     * @param stockQuantity
     * @param type
     * @param taxStatus
     * @param shippingRequired
     * @param relatedIds
     * @param dateOnSaleFrom
     * @param price
     * @param downloadExpiry
     * @param stockStatus
     * @param links
     * @param id
     * @param sku
     * @param slug
     * @param buttonText
     * @param images
     * @param dateModifiedGmt
     * @param backordered
     * @param weight
     * @param defaultAttributes
     * @param shortDescription
     * @param tags
     * @param menuOrder
     * @param backorders
     * @param groupedProducts
     * @param name
     * @param dateOnSaleToGmt
     * @param permalink
     * @param status
     * @param shippingClass
     * @param upsellIds
     * @param virtual
     * @param downloadable
     * @param dateOnSaleTo
     * @param downloadLimit
     * @param description
     * @param crossSellIds
     * @param shippingClassId
     * @param catalogVisibility
     * @param soldIndividually
     * @param metaData
     * @param priceHtml
     * @param dateCreated
     * @param downloads
     * @param variations
     * @param averageRating
     * @param onSale
     * @param dateOnSaleFromGmt
     * @param categories
     * @param shippingTaxable
     * @param taxClass
     * @param externalUrl
     * @param dateCreatedGmt
     * @param salePrice
     * @param backordersAllowed
     * @param dateModified
     * @param totalSales
     * @param ratingCount
     * @param parentId
     * @param reviewsAllowed
     * @param attributes
     * @param dimensions
     */
    public Product(Integer id, String name, String slug, String permalink, String dateCreated, String dateCreatedGmt, String dateModified, String dateModifiedGmt, String type, String status, Boolean featured, String catalogVisibility, String description, String shortDescription, String sku, String price, String regularPrice, String salePrice, Object dateOnSaleFrom, Object dateOnSaleFromGmt, Object dateOnSaleTo, Object dateOnSaleToGmt, String priceHtml, Boolean onSale, Boolean purchasable, Integer totalSales, Boolean virtual, Boolean downloadable, List<Object> downloads, Integer downloadLimit, Integer downloadExpiry, String externalUrl, String buttonText, String taxStatus, String taxClass, Boolean manageStock, Object stockQuantity, String stockStatus, String backorders, Boolean backordersAllowed, Boolean backordered, Boolean soldIndividually, String weight, Dimensions dimensions, Boolean shippingRequired, Boolean shippingTaxable, String shippingClass, Integer shippingClassId, Boolean reviewsAllowed, String averageRating, Integer ratingCount, List<Integer> relatedIds, List<Object> upsellIds, List<Object> crossSellIds, Integer parentId, String purchaseNote, List<Category> categories, List<Object> tags, List<Image> images, List<Attribute> attributes, List<Object> defaultAttributes, List<Object> variations, List<Object> groupedProducts, Integer menuOrder, List<MetaDatum> metaData, Links links) {
        super();
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.permalink = permalink;
        this.dateCreated = dateCreated;
        this.dateCreatedGmt = dateCreatedGmt;
        this.dateModified = dateModified;
        this.dateModifiedGmt = dateModifiedGmt;
        this.type = type;
        this.status = status;
        this.featured = featured;
        this.catalogVisibility = catalogVisibility;
        this.description = description;
        this.shortDescription = shortDescription;
        this.sku = sku;
        this.price = price;
        this.regularPrice = regularPrice;
        this.salePrice = salePrice;
        this.dateOnSaleFrom = dateOnSaleFrom;
        this.dateOnSaleFromGmt = dateOnSaleFromGmt;
        this.dateOnSaleTo = dateOnSaleTo;
        this.dateOnSaleToGmt = dateOnSaleToGmt;
        this.priceHtml = priceHtml;
        this.onSale = onSale;
        this.purchasable = purchasable;
        this.totalSales = totalSales;
        this.virtual = virtual;
        this.downloadable = downloadable;
        this.downloads = downloads;
        this.downloadLimit = downloadLimit;
        this.downloadExpiry = downloadExpiry;
        this.externalUrl = externalUrl;
        this.buttonText = buttonText;
        this.taxStatus = taxStatus;
        this.taxClass = taxClass;
        this.manageStock = manageStock;
        this.stockQuantity = stockQuantity;
        this.stockStatus = stockStatus;
        this.backorders = backorders;
        this.backordersAllowed = backordersAllowed;
        this.backordered = backordered;
        this.soldIndividually = soldIndividually;
        this.weight = weight;
        this.dimensions = dimensions;
        this.shippingRequired = shippingRequired;
        this.shippingTaxable = shippingTaxable;
        this.shippingClass = shippingClass;
        this.shippingClassId = shippingClassId;
        this.reviewsAllowed = reviewsAllowed;
        this.averageRating = averageRating;
        this.ratingCount = ratingCount;
        this.relatedIds = relatedIds;
        this.upsellIds = upsellIds;
        this.crossSellIds = crossSellIds;
        this.parentId = parentId;
        this.purchaseNote = purchaseNote;
        this.categories = categories;
        this.tags = tags;
        this.images = images;
        this.attributes = attributes;
        this.defaultAttributes = defaultAttributes;
        this.variations = variations;
        this.groupedProducts = groupedProducts;
        this.menuOrder = menuOrder;
        this.metaData = metaData;
        this.links = links;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product withName(String name) {
        this.name = name;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Product withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Product withPermalink(String permalink) {
        this.permalink = permalink;
        return this;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Product withDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getDateCreatedGmt() {
        return dateCreatedGmt;
    }

    public void setDateCreatedGmt(String dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
    }

    public Product withDateCreatedGmt(String dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
        return this;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public Product withDateModified(String dateModified) {
        this.dateModified = dateModified;
        return this;
    }

    public String getDateModifiedGmt() {
        return dateModifiedGmt;
    }

    public void setDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
    }

    public Product withDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product withType(String type) {
        this.type = type;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product withStatus(String status) {
        this.status = status;
        return this;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Product withFeatured(Boolean featured) {
        this.featured = featured;
        return this;
    }

    public String getCatalogVisibility() {
        return catalogVisibility;
    }

    public void setCatalogVisibility(String catalogVisibility) {
        this.catalogVisibility = catalogVisibility;
    }

    public Product withCatalogVisibility(String catalogVisibility) {
        this.catalogVisibility = catalogVisibility;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Product withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Product withSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Product withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Product withRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
        return this;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public Product withSalePrice(String salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public Object getDateOnSaleFrom() {
        return dateOnSaleFrom;
    }

    public void setDateOnSaleFrom(Object dateOnSaleFrom) {
        this.dateOnSaleFrom = dateOnSaleFrom;
    }

    public Product withDateOnSaleFrom(Object dateOnSaleFrom) {
        this.dateOnSaleFrom = dateOnSaleFrom;
        return this;
    }

    public Object getDateOnSaleFromGmt() {
        return dateOnSaleFromGmt;
    }

    public void setDateOnSaleFromGmt(Object dateOnSaleFromGmt) {
        this.dateOnSaleFromGmt = dateOnSaleFromGmt;
    }

    public Product withDateOnSaleFromGmt(Object dateOnSaleFromGmt) {
        this.dateOnSaleFromGmt = dateOnSaleFromGmt;
        return this;
    }

    public Object getDateOnSaleTo() {
        return dateOnSaleTo;
    }

    public void setDateOnSaleTo(Object dateOnSaleTo) {
        this.dateOnSaleTo = dateOnSaleTo;
    }

    public Product withDateOnSaleTo(Object dateOnSaleTo) {
        this.dateOnSaleTo = dateOnSaleTo;
        return this;
    }

    public Object getDateOnSaleToGmt() {
        return dateOnSaleToGmt;
    }

    public void setDateOnSaleToGmt(Object dateOnSaleToGmt) {
        this.dateOnSaleToGmt = dateOnSaleToGmt;
    }

    public Product withDateOnSaleToGmt(Object dateOnSaleToGmt) {
        this.dateOnSaleToGmt = dateOnSaleToGmt;
        return this;
    }

    public String getPriceHtml() {
        return priceHtml;
    }

    public void setPriceHtml(String priceHtml) {
        this.priceHtml = priceHtml;
    }

    public Product withPriceHtml(String priceHtml) {
        this.priceHtml = priceHtml;
        return this;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Product withOnSale(Boolean onSale) {
        this.onSale = onSale;
        return this;
    }

    public Boolean getPurchasable() {
        return purchasable;
    }

    public void setPurchasable(Boolean purchasable) {
        this.purchasable = purchasable;
    }

    public Product withPurchasable(Boolean purchasable) {
        this.purchasable = purchasable;
        return this;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public Product withTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
        return this;
    }

    public Boolean getVirtual() {
        return virtual;
    }

    public void setVirtual(Boolean virtual) {
        this.virtual = virtual;
    }

    public Product withVirtual(Boolean virtual) {
        this.virtual = virtual;
        return this;
    }

    public Boolean getDownloadable() {
        return downloadable;
    }

    public void setDownloadable(Boolean downloadable) {
        this.downloadable = downloadable;
    }

    public Product withDownloadable(Boolean downloadable) {
        this.downloadable = downloadable;
        return this;
    }

    public List<Object> getDownloads() {
        return downloads;
    }

    public void setDownloads(List<Object> downloads) {
        this.downloads = downloads;
    }

    public Product withDownloads(List<Object> downloads) {
        this.downloads = downloads;
        return this;
    }

    public Integer getDownloadLimit() {
        return downloadLimit;
    }

    public void setDownloadLimit(Integer downloadLimit) {
        this.downloadLimit = downloadLimit;
    }

    public Product withDownloadLimit(Integer downloadLimit) {
        this.downloadLimit = downloadLimit;
        return this;
    }

    public Integer getDownloadExpiry() {
        return downloadExpiry;
    }

    public void setDownloadExpiry(Integer downloadExpiry) {
        this.downloadExpiry = downloadExpiry;
    }

    public Product withDownloadExpiry(Integer downloadExpiry) {
        this.downloadExpiry = downloadExpiry;
        return this;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public Product withExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
        return this;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public Product withButtonText(String buttonText) {
        this.buttonText = buttonText;
        return this;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }

    public Product withTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
        return this;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public Product withTaxClass(String taxClass) {
        this.taxClass = taxClass;
        return this;
    }

    public Boolean getManageStock() {
        return manageStock;
    }

    public void setManageStock(Boolean manageStock) {
        this.manageStock = manageStock;
    }

    public Product withManageStock(Boolean manageStock) {
        this.manageStock = manageStock;
        return this;
    }

    public Object getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Object stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Product withStockQuantity(Object stockQuantity) {
        this.stockQuantity = stockQuantity;
        return this;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Product withStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
        return this;
    }

    public String getBackorders() {
        return backorders;
    }

    public void setBackorders(String backorders) {
        this.backorders = backorders;
    }

    public Product withBackorders(String backorders) {
        this.backorders = backorders;
        return this;
    }

    public Boolean getBackordersAllowed() {
        return backordersAllowed;
    }

    public void setBackordersAllowed(Boolean backordersAllowed) {
        this.backordersAllowed = backordersAllowed;
    }

    public Product withBackordersAllowed(Boolean backordersAllowed) {
        this.backordersAllowed = backordersAllowed;
        return this;
    }

    public Boolean getBackordered() {
        return backordered;
    }

    public void setBackordered(Boolean backordered) {
        this.backordered = backordered;
    }

    public Product withBackordered(Boolean backordered) {
        this.backordered = backordered;
        return this;
    }

    public Boolean getSoldIndividually() {
        return soldIndividually;
    }

    public void setSoldIndividually(Boolean soldIndividually) {
        this.soldIndividually = soldIndividually;
    }

    public Product withSoldIndividually(Boolean soldIndividually) {
        this.soldIndividually = soldIndividually;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Product withWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Product withDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    public Boolean getShippingRequired() {
        return shippingRequired;
    }

    public void setShippingRequired(Boolean shippingRequired) {
        this.shippingRequired = shippingRequired;
    }

    public Product withShippingRequired(Boolean shippingRequired) {
        this.shippingRequired = shippingRequired;
        return this;
    }

    public Boolean getShippingTaxable() {
        return shippingTaxable;
    }

    public void setShippingTaxable(Boolean shippingTaxable) {
        this.shippingTaxable = shippingTaxable;
    }

    public Product withShippingTaxable(Boolean shippingTaxable) {
        this.shippingTaxable = shippingTaxable;
        return this;
    }

    public String getShippingClass() {
        return shippingClass;
    }

    public void setShippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
    }

    public Product withShippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
        return this;
    }

    public Integer getShippingClassId() {
        return shippingClassId;
    }

    public void setShippingClassId(Integer shippingClassId) {
        this.shippingClassId = shippingClassId;
    }

    public Product withShippingClassId(Integer shippingClassId) {
        this.shippingClassId = shippingClassId;
        return this;
    }

    public Boolean getReviewsAllowed() {
        return reviewsAllowed;
    }

    public void setReviewsAllowed(Boolean reviewsAllowed) {
        this.reviewsAllowed = reviewsAllowed;
    }

    public Product withReviewsAllowed(Boolean reviewsAllowed) {
        this.reviewsAllowed = reviewsAllowed;
        return this;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public Product withAverageRating(String averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Product withRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
        return this;
    }

    public List<Integer> getRelatedIds() {
        return relatedIds;
    }

    public void setRelatedIds(List<Integer> relatedIds) {
        this.relatedIds = relatedIds;
    }

    public Product withRelatedIds(List<Integer> relatedIds) {
        this.relatedIds = relatedIds;
        return this;
    }

    public List<Object> getUpsellIds() {
        return upsellIds;
    }

    public void setUpsellIds(List<Object> upsellIds) {
        this.upsellIds = upsellIds;
    }

    public Product withUpsellIds(List<Object> upsellIds) {
        this.upsellIds = upsellIds;
        return this;
    }

    public List<Object> getCrossSellIds() {
        return crossSellIds;
    }

    public void setCrossSellIds(List<Object> crossSellIds) {
        this.crossSellIds = crossSellIds;
    }

    public Product withCrossSellIds(List<Object> crossSellIds) {
        this.crossSellIds = crossSellIds;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Product withParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getPurchaseNote() {
        return purchaseNote;
    }

    public void setPurchaseNote(String purchaseNote) {
        this.purchaseNote = purchaseNote;
    }

    public Product withPurchaseNote(String purchaseNote) {
        this.purchaseNote = purchaseNote;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Product withCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Product withTags(List<Object> tags) {
        this.tags = tags;
        return this;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Product withImages(List<Image> images) {
        this.images = images;
        return this;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Product withAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    public List<Object> getDefaultAttributes() {
        return defaultAttributes;
    }

    public void setDefaultAttributes(List<Object> defaultAttributes) {
        this.defaultAttributes = defaultAttributes;
    }

    public Product withDefaultAttributes(List<Object> defaultAttributes) {
        this.defaultAttributes = defaultAttributes;
        return this;
    }

    public List<Object> getVariations() {
        return variations;
    }

    public void setVariations(List<Object> variations) {
        this.variations = variations;
    }

    public Product withVariations(List<Object> variations) {
        this.variations = variations;
        return this;
    }

    public List<Object> getGroupedProducts() {
        return groupedProducts;
    }

    public void setGroupedProducts(List<Object> groupedProducts) {
        this.groupedProducts = groupedProducts;
    }

    public Product withGroupedProducts(List<Object> groupedProducts) {
        this.groupedProducts = groupedProducts;
        return this;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Product withMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
        return this;
    }

    public List<MetaDatum> getMetaData() {
        return metaData;
    }

    public void setMetaData(List<MetaDatum> metaData) {
        this.metaData = metaData;
    }

    public Product withMetaData(List<MetaDatum> metaData) {
        this.metaData = metaData;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Product withLinks(Links links) {
        this.links = links;
        return this;
    }

}