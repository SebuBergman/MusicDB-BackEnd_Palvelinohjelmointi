package hhpalvelinohjelmointi.Musicdb.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {

	List<Song> findByTitle(String title);

	List<Song> findByGenre(String genre);

}