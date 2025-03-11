package com.foodelivery.order_service.service;

import com.foodelivery.order_service.dto.MenuDto;
import com.foodelivery.order_service.exception.ItemNotFoundException;
import com.foodelivery.order_service.model.Menu;
import com.foodelivery.order_service.repo.MenuRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepo menuRepo;

    public MenuService(MenuRepo menuRepo){
        this.menuRepo = menuRepo;
    }

    public ResponseEntity<List<MenuDto>> getMenu(int restaurantId){
        List<Menu> menu = menuRepo.findByRestaurantId(restaurantId);
        List<MenuDto> menuDto = new ArrayList<>();
        for(Menu item : menu){
            MenuDto itemDto = new MenuDto(item.getItemId(),
                    item.getRestaurantId(),
                    item.getItemName(),
                    item.getPrice());
            menuDto.add(itemDto);
        }

        return new ResponseEntity<List<MenuDto>>(menuDto, HttpStatus.OK);
    }

    public ResponseEntity<MenuDto> addToMenu(MenuDto menuDto){
        Menu menu = new Menu();
        menu.setItemId(menuDto.itemId());
        menu.setRestaurantId(menuDto.restaurantId());
        menu.setItemName(menuDto.itemName());
        menu.setPrice(menuDto.price());

        menuRepo.save(menu);

        return new ResponseEntity<>(menuDto, HttpStatus.CREATED);
    }

    public ResponseEntity<MenuDto> updateMenu(int itemId, MenuDto menuDto){
        Menu menu = menuRepo.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Unable to find the itemId : " + itemId));

        if (menuDto.itemName() != null && !menuDto.itemName().isBlank()) {
            menu.setItemName(menuDto.itemName());
        }

        if (menuDto.restaurantId() != null && !menuDto.restaurantId().equals(menu.getRestaurantId())) {
            menu.setRestaurantId(menuDto.restaurantId());
        }

        if (menuDto.price() != null && !menuDto.price().equals(menu.getPrice())) {
            menu.setPrice(menuDto.price());
        }

        menuRepo.save(menu);

        return new ResponseEntity<>(menuDto, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteFromMenu(int itemId){
        if(menuRepo.existsById(itemId)){
            menuRepo.deleteById(itemId);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }else {
            throw new ItemNotFoundException("Unable to find the itemId : " + itemId);
        }
    }
}
