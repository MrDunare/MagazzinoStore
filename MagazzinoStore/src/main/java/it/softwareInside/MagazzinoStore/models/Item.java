package it.softwareInside.MagazzinoStore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Item {

	//chiave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@Column(name = "costo")
	private double costo;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "tipologia")
	private String tipologia;
	
	
	@SuppressWarnings("unused")
	private Item(double costo,String marca,String tipologia) {
		setCosto(costo);
		setMarca(marca);
		setTipologia(tipologia);
	}
	
}
