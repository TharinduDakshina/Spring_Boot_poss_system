package com.example.SpringBoot_revition.service.impl;

import com.example.SpringBoot_revition.dto.request.ItemDTO;
import com.example.SpringBoot_revition.entity.Item;
import com.example.SpringBoot_revition.repository.ItemRepo;
import com.example.SpringBoot_revition.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String saveItem(ItemDTO itemDTO) {
        Item item = modelMapper.map(itemDTO, Item.class);

        if (!itemRepo.existsById(item.getCode())) {
            itemRepo.save(item);
            return "updated";
        }else {
            return "Already exist";
        }
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getCode())) {
            Item item = itemRepo.getReferenceById(itemDTO.getCode());
            item.setName(itemDTO.getName());
            item.setQty(itemDTO.getQty());
            item.setUnitPrice(itemDTO.getUnitPrice());
            item.setMeasuringUnitTypes(itemDTO.getMeasuringUnitTypes());

            itemRepo.save(item);
            return true;
        }else {
            return false;
        }
    }


    @Override
    public ArrayList<ItemDTO> getAll() {
        ArrayList<Item> all = (ArrayList<Item>) itemRepo.findAll();
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        allItems=modelMapper.map(all,new TypeToken<ArrayList<ItemDTO>>(){}.getType());
        return allItems;
    }

    @Override
    public ItemDTO findByCode(int itemCode) {
        Optional<Item> item = itemRepo.findById(itemCode);
        if (item.isPresent()) {
            ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);
            return itemDTO;
        }else {
            return null;
        }

    }

    @Override
    public boolean deleteItem(int code) {
        itemRepo.deleteById(code);
        return true;
    }
}

