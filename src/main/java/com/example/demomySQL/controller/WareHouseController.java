package com.example.demomySQL.controller;

import com.example.demomySQL.model.*;
import com.example.demomySQL.service.WareHouseService;
import com.example.demomySQL.utils.ApplicationConstants;
import com.example.demomySQL.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WareHouseController implements ApplicationConstants {

    @Autowired
    WareHouseService wareHouseService;

    /***
     * Api updates the price of a product in products table if exists,
     * If product dose not exist in the database returns status as 400
     * @param payload - POJO of type SetProductPriceRequest
     * @return returns a response object
     */
    @PostMapping("/setProductPrice")
    public Response updatePrice(@Valid @RequestBody SetProductPriceRequest payload) {
        Response response = new Response();
        try {
            wareHouseService.updatePrice( payload.getPrice(), payload.getSerialNo() );
            handleSuccessResponse(response,null);
        } catch (Exception e) {
            handleError(e,response);
        }
        return response;
    }

    /***
     * Api adds new product in products table,
     * If group given in the request body does not exist, api creates new group
     * If product with the given serial_no already exists in the table returns status as 400
     * @param payload - POJO of type ProductPramModel
     * @return returns a response object
     */
    @PostMapping("/addProduct")
    public Response addProduct(@Valid @RequestBody ProductPramModel payload) {
        System.out.println("productParam :" + payload);
        Response response = new Response();
        try {
            wareHouseService.addProduct(payload);
            handleSuccessResponse(response,null);
        } catch (Exception e) {
            handleError(e,response);
        }
        return response;
    }

    /***
     * Api changes the product's group in products table,
     * If group given in the request body does not exist, api creates new group
     * @param payload - POJO of type ChangeProductGroupRequest
     * @return returns a response object
     */
    @PostMapping("/changeProductGroup")
    public Response changeProductGroup(@Valid @RequestBody ChangeProductGroupRequest payload) {
        System.out.println("productParam :" + payload);
        Response response = new Response();
        try {
            wareHouseService.changeProductGroup(payload.getGroupName(), payload.getSerialNo());
            handleSuccessResponse(response,null);
        } catch (Exception e) {
            handleError(e,response);
        }
        return response;
    }

    /***
     *  Fetches the list of groups available in the db, with the total number of products and total value of all products
     * @return returns a response object
     */
    @GetMapping("/getGroupProducts")
    public Response getGroupProducts() {

        Response response = new Response();
//        try {
            List<GroupProductsTable> table = wareHouseService.getGroupProducts();
            handleSuccessResponse(response,table);
        /*} catch (Exception e) {
            handleError(e,response);
        }*/
        return response;
    }

    private void handleError(Exception e, Response response) {
        response.setStatus(400);
        response.setStatusMsg(ERROR);
        response.setErrorMsg(e.getMessage());
    }

    private void handleSuccessResponse(Response response, Object data){
        response.setStatus(200);
        response.setData(data);
        response.setStatusMsg(SUCCESS);
    }

}
