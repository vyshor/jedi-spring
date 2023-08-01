package com.service.spring.jedi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@ConfigurationProperties(prefix = "sop.swagger")
@Component
public class SwaggerConfigProperties implements Serializable {
    /**
     * Whether to open Swagger
     */
    private boolean enable = false;
    /**
     * Packets to be scanned
     */
    private String packageScan;
    /**
     * Title
     */
    private String title;
    /**
     * describe
     */
    private String description;
    /**
     * Version information
     */
    private String version;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPackageScan() {
        return packageScan;
    }

    public void setPackageScan(String packageScan) {
        this.packageScan = packageScan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}