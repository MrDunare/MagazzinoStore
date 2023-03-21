package it.softwareInside.MagazzinoStore.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.service.ItemService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	
	@Autowired
	ItemService itemService;
	
	
	
	@GetMapping("/getSomma")
	public double getSomma(){
		return itemService.somma();
	}
	@GetMapping("/getAll")
	public Iterable<Item>getAll(){
		return itemService.getAllData();
	}
	@GetMapping("/somma")
	public double somma() {
		return itemService.somma();
	}
	
	@PostMapping("/update")
	public boolean update(@RequestBody Item item) {
		itemService.addItem(item);
		return true;
	}
	
	@PostMapping("/add")
	public boolean add(@RequestBody Item item) {
		itemService.addItem(item);
		return true;	
	}
	@DeleteMapping("/remove")
	public boolean remove(@RequestParam ("id")int id) {
		itemService.removeItem(id);
		return true;
	}
	
	
}
