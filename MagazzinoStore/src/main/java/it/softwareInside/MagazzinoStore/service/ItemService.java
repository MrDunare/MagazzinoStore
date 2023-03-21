package it.softwareInside.MagazzinoStore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	
	/**
	 * somma dei costi di tutti gli elementi
	 * del magazzino
	 * @return
	 */
	public double somma(){
		int sommaTotale = 0;
	
		for(Item item :itemRepository.findAll())
			sommaTotale += item.getCosto();
			
		return sommaTotale;
		
	}
	
	/**
	 * metodo che prende in input un object
	 * di tipo item...se diverso da null
	 * torno true e lo aggiungo
	 * 
	 * @param item
	 * @return
	 */
	public boolean addItem(Item item) {
		
		if(item == null)
			return false;
		
		try {
			itemRepository.save(item);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	/**
	 * update i valori
	 * @param item
	 * @return
	 */
	public boolean updateItem(Item item) {
		
		return addItem(item);
		
	}
	
	/**
	 * cancello un oggetto dal database
	 * @param id
	 * @return
	 */
	public Item removeItem(int id) {
		
		try {
			Item item = itemRepository.findById(id).get();
			itemRepository.deleteById(id);
			
			return item;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public Item getItemByIdId(int id) {
		try {
			
			return itemRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Iterable<Item> getAllData() {
		
		return itemRepository.findAll();
	}
}
