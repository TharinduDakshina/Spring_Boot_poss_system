package com.example.SpringBoot_revition.service;

import com.example.SpringBoot_revition.dto.request.ItemDTO;

import java.util.ArrayList;

public interface ItemService {
    String saveItem(ItemDTO itemDTO);

    boolean updateItem(ItemDTO itemDTO);

    ArrayList<ItemDTO> getAll();

    ItemDTO findByCode(int itemCode);

    boolean deleteItem(int code);
}
