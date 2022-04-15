package hhpalvelinohjelmointi.Musicdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hhpalvelinohjelmointi.Musicdb.domain.Album;
import hhpalvelinohjelmointi.Musicdb.domain.AlbumRepository;
import hhpalvelinohjelmointi.Musicdb.domain.Song;
import hhpalvelinohjelmointi.Musicdb.domain.SongRepository;
import hhpalvelinohjelmointi.Musicdb.domain.User;
import hhpalvelinohjelmointi.Musicdb.domain.UserRepository;

@SpringBootApplication
public class MusicdbApplication {
	private static final Logger log = LoggerFactory.getLogger(MusicdbApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MusicdbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Musicdatabase(SongRepository songrepository, AlbumRepository albumrepository, UserRepository userrepository) {
		return (args) -> {
			log.info("save a couple of songs");
			Album sighnomore = new Album("Sigh No More", "Mumford & Sons", "Indie Folk, Folk Rock, Bluegrass", 2009, "https://upload.wikimedia.org/wikipedia/en/f/f3/Mumfordsonssighnomore.jpg");
			albumrepository.save(sighnomore);
			
			Album equals = new Album("=", "Ed Sheeran", "Pop", 2021, "https://upload.wikimedia.org/wikipedia/en/c/cd/Ed_Sheeran_-_Equals.png");
			albumrepository.save(equals);
			
			Album studiokillers = new Album("Studio Killers", "Studio Killers", "Electropop / House", 2011, "https://upload.wikimedia.org/wikipedia/en/f/f8/Studio_Killers_Album.png");
			albumrepository.save(studiokillers);
			
			Album maailmaotmv = new Album("Maailma on tehty meitä varten", "Haloo Helsinki!", "Pop rock / Vaihtoehtorock", 2013, "https://upload.wikimedia.org/wikipedia/fi/c/c3/Hh-maailma_on_tehty_meita_varten.png");
			albumrepository.save(maailmaotmv);
			
			Album whosnext = new Album("Who's Next", "The Who", "Hard Rock", 1971, "https://upload.wikimedia.org/wikipedia/en/4/44/Whosnext.jpg");
			albumrepository.save(whosnext);
			
			Album nummela = new Album("Nummela", "Anssi Kela", "Pop", 2001, "https://upload.wikimedia.org/wikipedia/en/2/25/Anssi_Kela_Nummela_album_cover.png");
			albumrepository.save(nummela);
			
			Album so = new Album("So", "Peter Gabriel", "Pop / Progressive Pop / Worldbeat", 1985, "https://upload.wikimedia.org/wikipedia/en/a/a4/So_%28album%29.png");
			albumrepository.save(so);
			
			Album demondays = new Album("Demon Days", "Gorillaz", "Alternative Rock / Hip Hop / Pop", 2005, "https://upload.wikimedia.org/wikipedia/en/d/df/Gorillaz_Demon_Days.PNG");
			albumrepository.save(demondays);
			
			Album unorthodoxj = new Album("Unorthodox Jukebox", "Bruno Mars", "Pop / R&B / Funk", 2012, "https://upload.wikimedia.org/wikipedia/en/7/77/BrunoMarsUJAlbumCover.png");
			albumrepository.save(unorthodoxj);
			
			Album one = new Album("1", "The Beatles", "Rock / Pop", 2000, "https://upload.wikimedia.org/wikipedia/en/b/be/The_Beatles_1_album_cover.jpg");
			albumrepository.save(one);
			
			//Mumford & songs Songs
			songrepository.save(new Song("Little Lion Man", "Folk Rock", 4.06, sighnomore));
			songrepository.save(new Song("Roll Away Your Stone", "Bluegrass", 4.23, sighnomore));
			songrepository.save(new Song("Winter Winds", "Indie Folk", 4.06, sighnomore));
			songrepository.save(new Song("The Cave", "Indie Folk", 3.37, sighnomore));
			
			//Ed Sheeran Songs
			songrepository.save(new Song("Shivers", "Dance-Pop", 3.27, equals));
			songrepository.save(new Song("Bad Habits", "Synth-pop", 3.51, equals));
			
			//Studio killers Songs
			songrepository.save(new Song("Ode to the Bouncer", "Electropop", 3.26, studiokillers));
			songrepository.save(new Song("Jenny", "Electropop", 3.35, studiokillers));
			
			//Haloo Helsinki! Songs
			songrepository.save(new Song("Vapaus käteen jää", "Pop rock", 4.07, maailmaotmv));
			songrepository.save(new Song("Huuda!", "Pop rock", 4.07, maailmaotmv));
			songrepository.save(new Song("Maailma on tehty meitä varten", "Pop rock", 4.35, maailmaotmv));
			
			//The Who Songs
			songrepository.save(new Song("Behind Blue Eyes", "Folk Rock", 3.41, whosnext));
			songrepository.save(new Song("Won't Get Fooled Again", "Progressive Rock", 8.32, whosnext));
			songrepository.save(new Song("Baba O'Riley", "Electronic Rock", 5.00, whosnext));
			
			//Anssi Kela Songs
			songrepository.save(new Song("Nummela", "Folk", 4.29, nummela));
			songrepository.save(new Song("Puistossa", "Folk / Hip Hop", 4.33, nummela));
			songrepository.save(new Song("Mikan faijan BMW", "Folk / Hip Hop", 4.14, nummela));
			
			//Peter Gabriel Songs
			songrepository.save(new Song("Red Rain", "Rock", 5.39, so));
			songrepository.save(new Song("Sledgehammer", "Dance-Rock", 5.12, so));
			songrepository.save(new Song("Don't Give Up", "Art Pop", 6.32, so));
			songrepository.save(new Song("In Your Eyes", "Worldbeat", 5.29, so));
			songrepository.save(new Song("Big Time", "Funk Rock", 4.26, so));
			
			//Bruno Mars Songs
			songrepository.save(new Song("Locked Out of Heaven", "Reggae Rock", 3.53, unorthodoxj));
			songrepository.save(new Song("Treasure", "Funk-Pop", 2.58, unorthodoxj));
			
			//Gorillaz Songs
			songrepository.save(new Song("Kids with Guns", "Alternative Rock", 3.45, demondays));
			songrepository.save(new Song("Dirty Harry", "Funk", 3.50, demondays));
			songrepository.save(new Song("Feel Good Inc.", "Alternative Rock / Rap Rock", 3.42, demondays));
			songrepository.save(new Song("Dare", "Funk", 4.05, demondays));
			
			//The Beatles Songs
			songrepository.save(new Song("Love Me Do", "R&B", 2.22, one));
			songrepository.save(new Song("Ticket to Ride", "Power Pop", 3.10, one));
			songrepository.save(new Song("Help!", "Folk Rock", 2.18, one));
			songrepository.save(new Song("Paperback Writer", "Hard Rock", 2.16, one));
			songrepository.save(new Song("Yellow Submarine", "Psychedelia", 2.38, one));
			songrepository.save(new Song("Eleanor Rigby", "Baroque Pop", 2.08, one));
			songrepository.save(new Song("Penny Lane", "Progressive Pop", 3.03, one));
			
			// Create a couple of users: admin and user with corresponding passwords
			User user1 = new User("user", "$2a$10$Xeh2yIAIZxTK0smH6Ct1UOeblzLjuMBqG0JoS8RJ1w8x0qBX5gUHy", "USER");
			User user2 = new User("admin", "$2a$10$4NEuiOObZgkcfAqA2SgZLOboYvtWZ.cLhXwYOYiwEBr22mUDTqS2a", "ADMIN");
			
			userrepository.save(user1);
			userrepository.save(user2);
			
			log.info("fetch all songs");
			for (Song song : songrepository.findAll()) {
				log.info(song.toString());
			}
		};
	}
}