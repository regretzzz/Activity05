/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */
package bentoApp.dao;

import org.slim3.datastore.Datastore;

import bentoApp.meta.DishModelMeta;
import bentoApp.model.DishModel;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
/**
 * Contains the functions that will be used to access the datastore.
 * @author Lehmar Cabrillos
 * @version 0.01
 * Version History
 * [04/13/2016] 0.01 – Lehmar Cabrillos  – Initial codes.
 */
public class DishDao {
 
    /**
     * Used to get only one 'dish' from the datastore with the same 'name'.
     * @param inputDish - contains the 'name' to be queried
     * @return DishModel returned by the query
     */ 
    public DishModel getDish(DishModel inputDish) {
        System.out.println("DishDao.getDish " + "start");
        // container for the query result
        DishModel dishModel = new DishModel();
        // use the meta object for filtering the results
        DishModelMeta meta = DishModelMeta.get();
        dishModel = Datastore.query(meta)
                        .filter(meta.name.equal(inputDish.getName()))
                        .asSingle();
        
        System.out.println("DishDao.getDish " + "end");
        return dishModel;
    }
    
    /**
     * Used to insert the 'dish' to the datastore
     * @param inputDish - the item to be inserted 
     */
    public void insertDish(DishModel inputDish) {
        System.out.println("DishDao.insertDish " + "start");
        Transaction transaction = Datastore.beginTransaction();
        // creating key and ID for the new entity
        Key parentKey = KeyFactory.createKey("Dish", inputDish.getName());
        Key key = Datastore.allocateId(parentKey, "DishModel");
        
        // setting the 'key' and 'id' of the model
        inputDish.setKey(key);
        inputDish.setId(key.getId());
        
        // adding the item to the datastore
        Datastore.put(inputDish);
        transaction.commit();
        System.out.println("DishDao.insertDish " + "end");
    }

}
