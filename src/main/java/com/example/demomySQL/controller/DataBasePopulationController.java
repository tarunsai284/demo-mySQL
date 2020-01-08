package com.example.demomySQL.controller;

import com.example.demomySQL.service.DataBasePopulationService;
import com.example.demomySQL.utils.ApplicationConstants;
import com.example.demomySQL.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value="/populateDb")
public class DataBasePopulationController implements ApplicationConstants {

    @Autowired
    DataBasePopulationService dataBasePopulationService;

    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("files") MultipartFile[] files) {
        Response response = new Response();

        try {
            MultipartFile product_list = files[1];
            MultipartFile group_list = files[0];
            dataBasePopulationService.processFile(product_list, group_list);
            response.setStatus(200);
            response.setStatusMsg(SUCCESS);
        } catch (Exception e) {
            handleError(e,response);
        }
        return response;
    }

    private void handleError(Exception e, Response response) {
        response.setStatus(400);
        response.setStatusMsg(ERROR);
        response.setErrorMsg(e.getMessage());
    }
}
