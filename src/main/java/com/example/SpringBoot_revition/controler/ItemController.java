package com.example.SpringBoot_revition.controler;

import com.example.SpringBoot_revition.dto.request.ItemDTO;
import com.example.SpringBoot_revition.repository.ItemRepo;
import com.example.SpringBoot_revition.service.ItemService;
import com.example.SpringBoot_revition.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "/getAll")
    public ResponseEntity<StandardResponse> getAll(){
        ArrayList<ItemDTO> all = itemService.getAll();
        return new ResponseEntity<StandardResponse>(new StandardResponse(
                200,"",all
        ), HttpStatus.OK);
    }

    @GetMapping(path = "/findByCode",params = "code")
    public ResponseEntity<StandardResponse> findByCode(@RequestParam(value = "code")int itemCode){
        ItemDTO items = itemService.findByCode(itemCode);
        if (items==null) {
            return new ResponseEntity<StandardResponse>(new StandardResponse(
                    401,"customer not found",null
            ), HttpStatus.OK);
        }else {
            return new ResponseEntity<StandardResponse>(new StandardResponse(
                    200,"",items
            ), HttpStatus.OK);
        }

    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemDTO itemDTO){
        String s = itemService.saveItem(itemDTO);

        return new ResponseEntity<StandardResponse>(new StandardResponse(
                200,s,null
        ), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<StandardResponse> updateItem(@RequestBody ItemDTO itemDTO){
        if (itemService.updateItem(itemDTO)) {
            return new ResponseEntity<StandardResponse>(new StandardResponse(
                    200,"updated",null
            ), HttpStatus.OK);
        }else {
            return new ResponseEntity<StandardResponse>(new StandardResponse(
                    500,"failed update",null
            ), HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<StandardResponse> DeleteItem(@PathVariable(value = "id")int code){
        if (itemService.deleteItem(code)) {
            return new ResponseEntity<StandardResponse>(new StandardResponse(
                    200,"Deleted",null
            ), HttpStatus.OK);
        }else {
            return new ResponseEntity<StandardResponse>(new StandardResponse(
                    500,"delete process failed.",null
            ), HttpStatus.OK);
        }
    }


}
