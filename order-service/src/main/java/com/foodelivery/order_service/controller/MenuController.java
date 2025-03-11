package com.foodelivery.order_service.controller;

import com.foodelivery.order_service.dto.MenuDto;
import com.foodelivery.order_service.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/menu")
@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/{RestaurantId}")
    public ResponseEntity<List<MenuDto>> getMenu(@PathVariable int restaurantId){
        return menuService.getMenu(restaurantId);
    }

    @PostMapping
    public ResponseEntity<MenuDto> addToMenu(@RequestBody MenuDto menuDto){
        return menuService.addToMenu(menuDto);
    }

    @PatchMapping("/{itemId}")
    public ResponseEntity<MenuDto> updateMenu(@PathVariable int itemId, @RequestBody MenuDto menuDto){
        return menuService.updateMenu(itemId, menuDto);
    }

    @DeleteMapping("/{itemId")
    public ResponseEntity<Void> deleteFromMenu(@PathVariable int itemId){
        return menuService.deleteFromMenu(itemId);
    }
}
