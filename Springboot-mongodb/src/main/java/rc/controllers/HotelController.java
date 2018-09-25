package rc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.dsl.BooleanExpression;

import rc.entities.Hotel;
import rc.repositories.HotelRepository;


@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	@GetMapping("/all")
	public List<Hotel> getAll() {
		List<Hotel> hotels = this.hotelRepository.findAll();
		return hotels;
	}
	
	@GetMapping("/{id}")
	public Optional<Hotel> findById(@PathVariable("id") String id) {
		Optional<Hotel> hotel = this.hotelRepository.findById(id);
		return hotel;
	}
	
	
	// get all information by filtering out maxPrice 
	@GetMapping("/price/{maxPrice}")
	public List<Hotel> getPricePerNight(@PathVariable("maxPrice") int maxPrice) {
		List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
		return hotels;
	}
	
	@GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        List<Hotel> hotels = this.hotelRepository.findByCity(city);
        return hotels;
    }
	
	
	@PutMapping
    public void insert(@RequestBody Hotel hotel){
        this.hotelRepository.insert(hotel);
}

    @PostMapping
    public void update(@RequestBody Hotel hotel){
        this.hotelRepository.save(hotel);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.hotelRepository.delete(id);
    }
    
    @GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country){
        // create a query class (QHotel)
        QHotel qHotel = new QHotel("hotel");

        // using the query class we can create the filters
        BooleanExpression filterByCountry = qHotel.address.country.eq(country);

        // we can then pass the filters to the findAll() method
        List<Hotel> hotels = (List<Hotel>) this.hotelRepository.findAll(filterByCountry);

        return hotels;
    }

//    @GetMapping("/recommended")
//    public List<Hotel> getRecommended(){
//        final int maxPrice = 100;
//        final int minRating = 7;
//
//        // create a query class (QHotel)
//        QHotel qHotel = new QHotel("hotel");
//
//        // using the query class we can create the filters
//        BooleanExpression filterByPrice = qHotel.pricePerNight.lt(maxPrice);
//        BooleanExpression filterByRating = qHotel.reviews.any().rating.gt(minRating);
//
//        // we can then pass the filters to the findAll() method
//        List<Hotel> hotels = (List<Hotel>) this.hotel
//        return hotels;
//    }
//	

}
