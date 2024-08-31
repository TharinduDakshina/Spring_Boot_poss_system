package com.example.SpringBoot_revition.util.mappers;

import com.example.SpringBoot_revition.dto.request.ItemDTO;
import com.example.SpringBoot_revition.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item dtoToEntity(ItemDTO itemDTO);

}
