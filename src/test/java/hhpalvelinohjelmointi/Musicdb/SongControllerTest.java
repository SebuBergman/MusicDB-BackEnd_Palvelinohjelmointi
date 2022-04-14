package hhpalvelinohjelmointi.Musicdb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hhpalvelinohjelmointi.Musicdb.domain.AlbumRepository;
import hhpalvelinohjelmointi.Musicdb.domain.Song;
import hhpalvelinohjelmointi.Musicdb.domain.SongRepository;

class SongControllerTest {
	@Autowired
	AlbumRepository albumrepository;
	
	@Autowired
	SongRepository songrepository;
	
	@Test
	public void whenGivenId_shouldUpdateSong_ifFound() {
		Song song = new Song();
		song.setId(60L);
		song.setTitle("Test Song Name");
		
		Song newSong = new Song();
		song.setTitle("Test Song Name");
		
		given(songrepository.findById(song.getId())).willReturn(Optional.of(song));
		
	}
}