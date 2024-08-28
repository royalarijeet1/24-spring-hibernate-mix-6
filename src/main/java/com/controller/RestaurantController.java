package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.RestaurantEntity;
import com.repository.RestaurantRepository;

@Controller
public class RestaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;

	@GetMapping("newrestaurant")
	public String newRestaurant() {

		return "NewRestaurant";
	}

	@PostMapping("saverestaurant")
	public String saveRestaurant(@Validated RestaurantEntity restaurantEntity,BindingResult result,Model model) {
	
		model.addAttribute("re", restaurantEntity);
		if(result.hasErrors()) {
//			System.out.println(result.getFieldError("name").getDefaultMessage());	
			model.addAttribute("result", result);
			return "NewRestaurant";
		}
		else
		{
			
			restaurantRepository.save(restaurantEntity);// insert
//			return "Success";
			
			return "redirect:/listrestaurants";
		}
		
	}
	
	@GetMapping("/listrestaurants")
	public String listRestaurants(Model model) {
		List<RestaurantEntity> restaurants = restaurantRepository.findAll();
		model.addAttribute("restaurants", restaurants);

		return "ListRestaurant";
	}
	
	@GetMapping("/deleterestaurant")
	public String deleteProduct(@RequestParam("restaurantId") Integer restaurantId) {
		
		restaurantRepository.deleteById(restaurantId);
		return "redirect:/listrestaurants";// do not open jsp
		// open an url

	}
	
	@GetMapping("/updaterestaurant")
	public String updateRestaurant(@RequestParam("restaurantId") Integer restaurantId,Model model) {

		
		Optional<RestaurantEntity> restaurant=restaurantRepository.findById(restaurantId);
		
		if(restaurant.isEmpty())
		{
			return "Error";
		}
		else
		{
			model.addAttribute("restaurant",restaurant.get());
			return "UpdateRestaurant";
		}
	}
	
	
	
}