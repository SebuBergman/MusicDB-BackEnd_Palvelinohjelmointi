package hhpalvelinohjelmointi.Musicdb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hhpalvelinohjelmointi.Musicdb.domain.Album;
import hhpalvelinohjelmointi.Musicdb.domain.AlbumRepository;
import hhpalvelinohjelmointi.Musicdb.domain.Song;
import hhpalvelinohjelmointi.Musicdb.domain.SongRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {
	@Autowired
	private SongRepository songrepository;
	
	@Autowired
	private AlbumRepository albumrepository;
	
	@Test
	public void findByTitleShouldReturnASong() {
		List<Song> song = songrepository.findByTitle("Little Lion Man");
		
		assertThat(song).hasSize(1);
		assertThat(song.get(0).getTitle()).isEqualTo("Little Lion Man");
	}
	
	@Test
	public void findByNameShouldReturnAnAlbum() {
		List<Album> album = albumrepository.findByName("Sigh No More");
		
		assertThat(album).hasSize(1);
		assertThat(album.get(0).getName()).isEqualTo("Sigh No More");
	}
	
	@Test
	public void CreateNewAlbum() {
		Album yellowsubmarine = new Album("Yellow Submarine", "The Beatles", "Psychedelia / Film Score", 1968, "https://upload.wikimedia.org/wikipedia/en/a/ac/TheBeatles-YellowSubmarinealbumcover.jpg");
		albumrepository.save(yellowsubmarine);
		assertThat(yellowsubmarine.getAlbumid()).isNotNull();
	}
	
	@Test
	public void CreateNewSong() {
		Album yellowsubmarine = new Album("Yellow Submarine", "The Beatles", "Psychedelia / Film Score", 1968, "https://upload.wikimedia.org/wikipedia/en/a/ac/TheBeatles-YellowSubmarinealbumcover.jpg");
		albumrepository.save(yellowsubmarine);
		
		Song song = new Song("Yellow Submarine", "Pop / Psychedelia", 1966, yellowsubmarine);
		songrepository.save(song);
		assertThat(song.getId()).isNotNull();
	}
}
