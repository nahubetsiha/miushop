package com.ea.miushop.domain;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Boolean catalogEnabled;

    private String productWalmartLink;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private Category category;

    @Version
    private int version = 0;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductWalmartLink() {
        return productWalmartLink;
    }

    public void setProductWalmartLink(String productWalmartLink) {
        this.productWalmartLink = productWalmartLink;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getCatalogEnabled() {
        return catalogEnabled;
    }

    public void setCatalogEnabled(Boolean catalogEnabled) {
        this.catalogEnabled = catalogEnabled;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
