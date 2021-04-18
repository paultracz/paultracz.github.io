package ca.sheridancollege.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.Equipment;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {
	
	public Optional<Equipment> findByName(String name);
	
	public List<Equipment> findByPriceGreaterThanEqualAndPriceLessThanEqual(Double pricemin, Double pricemax);
	
	public List<Equipment> findByQuantityGreaterThanEqualAndQuantityLessThanEqual(Integer quantitymin, Integer quantitymax);
}
