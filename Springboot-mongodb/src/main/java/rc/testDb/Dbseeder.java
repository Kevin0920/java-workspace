package rc.testDb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import rc.entities.Address;
import rc.entities.Hotel;
import rc.entities.Review;
import rc.repositories.HotelRepository;

public class Dbseeder implements CommandLineRunner {
	private HotelRepository hotelRepository;
	
	public Dbseeder(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		
		Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                )
        );

        Hotel sofitel = new Hotel(
                "Sofitel",
                200,
                new Address("Rome", "Italy"),
                new ArrayList<>()
        );

        // drop all hotels
        this.hotelRepository.deleteAll();

        //add our hotels to the database
        List<Hotel> s = Arrays.asList(marriot, ibis, sofitel);
        this.hotelRepository.save(s);
	}
}
