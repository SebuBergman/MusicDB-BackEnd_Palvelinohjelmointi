package hhpalvelinohjelmointi.Musicdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hhpalvelinohjelmointi.Musicdb.domain.Album;
import hhpalvelinohjelmointi.Musicdb.domain.AlbumRepository;
import hhpalvelinohjelmointi.Musicdb.domain.Song;
import hhpalvelinohjelmointi.Musicdb.domain.SongRepository;

@CrossOrigin
@Controller
public class RestController {
	@Autowired
	private SongRepository songrepository;
	
	@Autowired
	private AlbumRepository albumrepository;
	
	//Restful services
		// RESTful service, Album findAll
		@CrossOrigin
		@GetMapping("/albums")
		public @ResponseBody List<Album> getAlbumRest() {	
			return (List<Album>) albumrepository.findAll();
		}
				
		// RESTful service, Album findById
		@CrossOrigin
		@GetMapping("/albums/{id}")
		public @ResponseBody Optional<Album> findAlbumRest(@PathVariable("id") Long albumId) {	
			return albumrepository.findById(albumId);
		}
			
		// RESTful service, Album findById and also get song details
		@CrossOrigin
		@GetMapping("/albums/{id}/songs")
		public @ResponseBody List<Song> findAlbumandSongsRest(@PathVariable("id") Long albumId) {	
			return albumrepository.findById(albumId).get().getSongs();
		}
				
		// RESTful service, Save albums
		@CrossOrigin
		@RequestMapping(value="/albums", method = RequestMethod.POST)
		public @ResponseBody Album saveAlbumRest(@RequestBody Album album) {	
			return albumrepository.save(album);
		}
			
	//All of the album endpoints
		//Restful service. Show all songs aka FindAll songs
		@CrossOrigin
		@GetMapping("/songs")
		public @ResponseBody List<Song> songListRest() {
			return (List<Song>) songrepository.findAll();
		}
				
		//Restful service for song database, FindById
		@CrossOrigin
		@GetMapping("/songs/{id}")
		public @ResponseBody Optional<Song> findSongRest(@PathVariable("id") Long songId) {
			return songrepository.findById(songId);
		}
				
		//Restful service for song database, FindById and also get album details
		@CrossOrigin
		@GetMapping("/songs/{id}/albums")
		public @ResponseBody Album findSongsandAlbumRest(@PathVariable("id") Long songId) {
			return songrepository.findById(songId).get().getAlbum();
		}
				
		//Restful service, Save Song
		@CrossOrigin
		@RequestMapping(value="/savesongs", method = RequestMethod.POST)
		public @ResponseBody Song saveSongRest(@RequestBody Song song) {
			return songrepository.save(song);
		}
	}