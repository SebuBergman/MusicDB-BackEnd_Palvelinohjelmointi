package hhpalvelinohjelmointi.Songdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hhpalvelinohjelmointi.Songdb.domain.Album;
import hhpalvelinohjelmointi.Songdb.domain.AlbumRepository;
import hhpalvelinohjelmointi.Songdb.domain.Song;
import hhpalvelinohjelmointi.Songdb.domain.SongRepository;
import hhpalvelinohjelmointi.Songdb.domain.User;
import hhpalvelinohjelmointi.Songdb.domain.UserRepository;

@SpringBootApplication
public class SongdbApplication {
	private static final Logger log = LoggerFactory.getLogger(SongdbApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SongdbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Songdatabase(SongRepository songrepository, AlbumRepository albumrepository, UserRepository userrepository) {
		return (args) -> {
			log.info("save a couple of songs");
			Album sighnomore = new Album("Sigh No More", "Mumford & Sons", "Indie Folk, Folk Rock, Bluegrass", 2009);
			albumrepository.save(sighnomore);
			
			Album equals = new Album("=", "Ed Sheeran", "Pop", 2021);
			albumrepository.save(equals);
			
			Album studiokillers = new Album("Studio Killers", "Studio Killers", "Electropop / House", 2011);
			albumrepository.save(studiokillers);
			
			Album maailmaotmv = new Album("Maailma on tehty meitä varten", "Haloo Helsinki!", "Pop rock / Vaihtoehtorock", 2013);
			albumrepository.save(maailmaotmv);
			
			Album whosnext = new Album("Who's Next", "The Who", "Hard Rock", 1971);
			albumrepository.save(whosnext);
			
			Album nummela = new Album("Nummela", "Anssi Kela", "Pop", 2001);
			albumrepository.save(nummela);
			
			Album so = new Album("So", "Peter Gabriel", "Pop / Progressive Pop / Worldbeat", 1985);
			albumrepository.save(so);
			
			//Mumford & songs Songs
			songrepository.save(new Song("Little Lion Man", "Indie Folk / Folk Rock", 4.06, sighnomore));
			songrepository.save(new Song("Roll Away Your Stone", "Indie Folk / Bluegrass", 4.23, sighnomore));
			songrepository.save(new Song("Winter Winds", "Indie Folk / Soul", 4.06, sighnomore));
			songrepository.save(new Song("The Cave", "Indie Folk / Soul", 3.37, sighnomore));
			
			//Ed Sheeran Songs
			songrepository.save(new Song("Shivers", "Dance-Pop", 3.27, equals));
			songrepository.save(new Song("Bad Habits", "Dance-Pop / Synth-pop", 3.51, equals));
			
			//Studio killers Songs
			songrepository.save(new Song("Ode to the Bouncer", "Electropop / House", 3.26, studiokillers));
			songrepository.save(new Song("Jenny", "Electropop / House", 3.35, studiokillers));
			
			//Haloo Helsinki! Songs
			songrepository.save(new Song("Vapaus käteen jää", "Pop rock", 4.07, maailmaotmv));
			songrepository.save(new Song("Huuda!", "Pop rock", 4.07, maailmaotmv));
			songrepository.save(new Song("Maailma on tehty meitä varten", "Pop rock", 4.35, maailmaotmv));
			
			//The Who Songs
			songrepository.save(new Song("Behind Blue Eyes", "Hard Rock / Folk Rock", 3.41, whosnext));
			songrepository.save(new Song("Won't Get Fooled Again", "Hard Rock / Progressive Rock", 8.32, whosnext));
			songrepository.save(new Song("Baba O'Riley", "Hard Rock / Electronic Rock", 5.00, whosnext));
			
			//Anssi Kela Songs
			songrepository.save(new Song("Nummela", "Folk", 4.29, nummela));
			songrepository.save(new Song("Puistossa", "Folk / Hip Hop", 4.33, nummela));
			songrepository.save(new Song("Mikan faijan BMW", "Folk / Hip Hop", 4.14, nummela));
			
			//Peter Gabriel Songs
			songrepository.save(new Song("Red Rain", "Rock", 5.39, so));
			songrepository.save(new Song("Sledgehammer", "Dance-Rock / Funk", 5.12, so));
			songrepository.save(new Song("Don't Give Up", "Art Pop", 6.32, so));
			songrepository.save(new Song("In Your Eyes", "Folk / Worldbeat", 5.29, so));
			songrepository.save(new Song("Big Time", "Funk Rock / Dance-Rock", 4.26, so));
			
			// Create a couple of users: admin and user, sebu with corresponding passwords
			User user1 = new User("user", "$2a$10$Xeh2yIAIZxTK0smH6Ct1UOeblzLjuMBqG0JoS8RJ1w8x0qBX5gUHy", "USER");
			User user2 = new User("admin", "$2a$10$4NEuiOObZgkcfAqA2SgZLOboYvtWZ.cLhXwYOYiwEBr22mUDTqS2a", "ADMIN");
			User user3 = new User("guest", "", "GUEST");
			
			userrepository.save(user1);
			userrepository.save(user2);
			userrepository.save(user3);
			
			log.info("fetch all songs");
			for (Song song : songrepository.findAll()) {
				log.info(song.toString());
			}
		};
	}
}