package hhpalvelinohjelmointi.Musicdatabase;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hhpalvelinohjelmointi.Musicdb.web.AlbumController;
import hhpalvelinohjelmointi.Musicdb.web.CombinedController;
import hhpalvelinohjelmointi.Musicdb.web.SongController;

@ExtendWith(SpringExtension.class)   
@SpringBootTest
class MusicdatabaseApplicationTests {

	@Autowired
	private CombinedController combinedController;
	
	@Autowired
	private SongController songController;
	
	@Autowired
	private AlbumController albumController;
	
	@Test
	public void combinedLoads() {
		assertThat(combinedController).isNotNull();
	}
	
	@Test
	public void songControllerLoads() {
		assertThat(songController).isNotNull();
	}
	
	@Test
	public void albumControllerLoads() {
		assertThat(albumController).isNotNull();
	}
}