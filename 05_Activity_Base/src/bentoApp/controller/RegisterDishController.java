/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2016
 * --------------------------------------------------------------------------- */
package bentoApp.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;


import bentoApp.dto.DishDto;
import bentoApp.service.DishService;


/**
 * Controller used to insert an 'dish' to the datastore.
 * @author Lehmar Cabrillos
 * @version 0.01
 * Version History
 * [04/13/2016] 0.01 � Lehmar Cabrillos  � Initial codes.
 */
public class RegisterDishController extends Controller {
    
    /**
     * Service object that will be used to call the insert function to datastore.
     */
    DishService bentoService = new DishService();
    
    /**
     * The funtion that will be ran first upon entering this controller.
     * Used to insert a 'dish' entity to the datastore.
     */
    @Override
    protected Navigation run() throws Exception {
        System.out.println("RegisterDishController.run " + "start");
        /**
         * Used to store the information from the request and send to the
         * service class.
         */
        DishDto dishDto = new DishDto();
        /**
         * Holds the data sent from the request of the client side.
         */
        JSONObject jsonObject= null;
        
        try {
            /**
             * TODO: Retrieve the request.
             *       Save the data to a JSON object.
             */
            
            jsonObject = new JSONObject(request.getReader().readLine());

            // Getting all the information sent from the request.
            String name = jsonObject.getString("name");
            String type = jsonObject.getString("type");
            Double price = jsonObject.getDouble("price");
               
            // setting the values of DTO from the request.
            /**
             * TODO: Set the dishDto with the retrieved data from the request.
             */
             dishDto.setName(name);
             dishDto.setType(type);
             dishDto.setPrice(price);
            // inserting the entity to the datastore.
            this.bentoService.insertDish(dishDto);
            
        } catch (Exception e) {
            System.out.println("RegisterDishController.run.exception " + e.toString());
        }
        
        System.out.println("RegisterDishController.run " + "end");
        // no screen redirection.
        return null;
    }

}
