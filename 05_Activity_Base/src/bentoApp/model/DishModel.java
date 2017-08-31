/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */
package bentoApp.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

/**
 * Contains the properties and methods for the 'dish' entity.
 * @author Lehmar Cabrillos
 * @version 0.01
 * Version History
 * [04/13/2016] 0.01 – Lehmar Cabrillos  – Initial codes.
 */
@Model(schemaVersion = 1)
public class DishModel implements Serializable {
    
    /**
     * The modeling version.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The primary key of the entity
     */
    @Attribute(primaryKey = true)
    private Key key;
    
    /**
     * The version of the entity.
     */
    @Attribute(version = true)
    private Long version;
    
    /**
     * The id of the 'dish'.
     */
    private Long id;
    
    /**
     * The name of the 'dish'.
     */
    private String name;
    
    /**
     * The type of the 'dish'.
     */
    private String type;
    
    /**
     * The cost of the 'dish'.
     */
    private Double price;

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }
    
    /**
     * Retrieves the id of the 'dish'.
     * @return the id of the 'dish'.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the id of the 'dish'
     * @param id - the value to be set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Retrives the name of the 'dish'.
     * @return the name of the 'dish'.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the 'dish'.
     * @param name - the value to be set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Retrieves the type of the 'dish'
     * @return the type of the 'dish'
     */
    public String getType() {
        return type;
    }
    
    /**
     * Sets the type of the 'dish'
     * @param type - the value to be set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Retrieves the cost of the 'dish'.
     * @return the cost of the 'dish'.
     */
    public Double getPrice() {
        return price;
    }
    
    /**
     * Sets the cost of the 'dish'.
     * @param cost - the value to be set.
     */
    public void setPrice(Double price) {
        this.price = price;
    } 
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DishModel other = (DishModel) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
