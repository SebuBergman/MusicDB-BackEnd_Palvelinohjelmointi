package hhpalvelinohjelmointi.Musicdb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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

	// Test if i can find a Song with the title Little Lion Man
	@Test
	public void findByTitleShouldReturnASong() {
		List<Song> song = songrepository.findByTitle("Little Lion Man");

		assertThat(song).hasSize(1);
		assertThat(song.get(0).getTitle()).isEqualTo("Little Lion Man");
	}

	@Test
	public void findByGenreShouldReturnASong() {
		List<Song> song = songrepository.findByGenre("Folk Rock");

		assertThat(song).hasSize(3);
		assertThat(song.get(0).getGenre()).isEqualTo("Folk Rock");
	}

	// Test if i can find an album with the name Sign No More
	@Test
	public void findByNameShouldReturnAnAlbum() {
		List<Album> album = albumrepository.findByName("Sigh No More");

		assertThat(album).hasSize(1);
		assertThat(album.get(0).getName()).isEqualTo("Sigh No More");
	}

	// Test if i can find an album with the name Sign No More
	@Test
	public void findByArtistShouldReturnAnAlbum() {
		List<Album> album = albumrepository.findByArtist("Mumford & Sons");

		assertThat(album).hasSize(1);
		assertThat(album.get(0).getArtist()).isEqualTo("Mumford & Sons");
	}

	// Test if i can find an album with the name Sign No More
	@Test
	public void findByReleaseYearShouldReturnAnAlbum() {
		List<Album> album = albumrepository.findByReleaseyear(2009);

		assertThat(album).hasSize(1);
		assertThat(album.get(0).getReleaseyear()).isEqualTo(2009);
	}

	// Testing creating an album
	@Test
	public void CreateNewAlbum() {
		Album yellowsubmarine = new Album("Yellow Submarine", "The Beatles", "Psychedelia / Film Score", 1968,
				"https://upload.wikimedia.org/wikipedia/en/a/ac/TheBeatles-YellowSubmarinealbumcover.jpg");
		albumrepository.save(yellowsubmarine);
		assertThat(yellowsubmarine.getAlbumid()).isNotNull();
	}

	// Testing creating a new song with album details
	@Test
	public void CreateNewSong() {
		Album yellowsubmarine = new Album("Yellow Submarine", "The Beatles", "Psychedelia / Film Score", 1968,
				"https://upload.wikimedia.org/wikipedia/en/a/ac/TheBeatles-YellowSubmarinealbumcover.jpg");
		albumrepository.save(yellowsubmarine);

		Song song = new Song("Yellow Submarine", "Pop / Psychedelia", 1966, yellowsubmarine);
		songrepository.save(song);
		assertThat(song.getId()).isNotNull();
	}
}
