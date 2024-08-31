package com.example.SpringBoot_revition.controler;

import com.example.SpringBoot_revition.dto.request.ItemDTO;
import com.example.SpringBoot_revition.repository.ItemRepo;
import com.example.SpringBoot_revition.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "/getAll")
    public ArrayList<ItemDTO> getAll(){
        return itemService.getAll();
    }

    @GetMapping(path = "/findByCode",params = "code")
    public ItemDTO findByCode(@RequestParam(value = "code")int itemCode){
        return itemService.findByCode(itemCode);
    }

    @PostMapping(path = "/save")
    public String saveItem(@RequestBody ItemDTO itemDTO){
        return itemService.saveItem(itemDTO);
    }

    @PutMapping(path = "/update")
    public String updateItem(@RequestBody ItemDTO itemDTO){
        if (itemService.updateItem(itemDTO)) {
            return "updated";
        }else {
            return "failed update process";
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public String DeleteItem(@PathVariable(value = "id")int code){
        if (itemService.deleteItem(code)) {
            return "Item deleted.";
        }else {
            return "item deleted process failed.";
        }
    }


}
