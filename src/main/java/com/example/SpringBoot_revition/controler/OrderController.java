package com.example.SpringBoot_revition.controler;

import com.example.SpringBoot_revition.dto.request.ItemDTO;
import com.example.SpringBoot_revition.dto.request.RequestOrderSave;
import com.example.SpringBoot_revition.service.OrderService;
import com.example.SpringBoot_revition.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSave requestOrderSave){

        String id =orderService.add(requestOrderSave);

        return new ResponseEntity<StandardResponse>(new StandardResponse(
                200,"save",id
        ), HttpStatus.OK);
    }
}
