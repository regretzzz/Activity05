/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */
package bentoApp.service;

import bentoApp.dao.DishDao;
import bentoApp.dto.DishDto;
import bentoApp.model.DishModel;


/**
 * Contains the functions for inserting an entity to the datastore.
 * @author Lehmar Cabrillos
 * @version 0.01
 * Version History
 * [04/13/2016] 0.01 – Lehmar Cabrillos  – Initial codes.
 */
public class DishService {
    /**
     * Use to access the DAO functions for the dishModel.
     */
    DishDao dishDao = new DishDao();
    
    /**
     * Used to insert an item to the datastore.
     * @param inputDish - the dto that contains the data to be stored
     *      in the model object.
     */
    public void insertDish(DishDto inputDish) {
        System.out.println("BentoService.insertIngredient " + "start");
        /**
         * Used to store the data from the DTO object to the model.
         * Used as parameters in passing to the DAO layer.
         */
        DishModel dishModel = new DishModel();

        // setting the data of the model from the dto
        dishModel.setId(inputDish.getId());
        dishModel.setName(inputDish.getName());
        dishModel.setType(inputDish.getType());
        dishModel.setPrice(inputDish.getPrice());

        try {
            // check if there is already an existing ingredient
            DishModel resultModel = this.dishDao.getDish(dishModel);
 
            // item doesn't exists
            if (null != resultModel) {
                // Item must not be inserted
                System.out.println("There is already an item with same name");
            } else {
                // add the item to the datastore
                try {
                    this.dishDao.insertDish(dishModel);
                    System.out.println("-------Inserting dish was successful.-------");
                } catch (Exception e) {
                    System.out.println("Exception in adding dish: " + e.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in inserting dish: " + e.toString());
        }
        
        System.out.println("BentoService.insertIngredient " + "end");
    }

}
