package hhpalvelinohjelmointi.Musicdatabase;

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

//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
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
	public void CreateNewAlbum() {
		Album yellowsubmarine = new Album("Yellow Submarine", "The Beatles", "Psychedelia / Film Score", 1968);
		albumrepository.save(yellowsubmarine);
		assertThat(yellowsubmarine.getAlbumid()).isNotNull();
	}
	
	@Test
	public void CreateNewSong() {
		Album yellowsubmarine = new Album("Yellow Submarine", "The Beatles", "Psychedelia / Film Score", 1968);
		albumrepository.save(yellowsubmarine);
		
		Song song = new Song("Yellow Submarine", "Pop / Psychedelia", 1966, yellowsubmarine);
		songrepository.save(song);
		assertThat(song.getId()).isNotNull();
	}
}
