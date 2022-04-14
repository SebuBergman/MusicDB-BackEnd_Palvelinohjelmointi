package hhpalvelinohjelmointi.Musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hhpalvelinohjelmointi.Musicdb.domain.Album;
import hhpalvelinohjelmointi.Musicdb.domain.AlbumRepository;

@CrossOrigin
@Controller
public class AlbumController {
	@Autowired
	private AlbumRepository albumrepository;
		
	//All of the album endpoints
		//Albums, Show all albums endpoint
		@RequestMapping("/albumlist")
		public String albumlist(Model model) {
			model.addAttribute("albums", albumrepository.findAll());
			return "albumlist";
		}
		
		//Music db, addAlbum endpoint
		@RequestMapping(value = "/addalbum")
		public String addAlbum(Model model) {
			model.addAttribute("album", new Album());
			return "addalbum";
		}
		
		//Music db, saveAlbum endpoint
		@RequestMapping(value = "/savealbum", method = RequestMethod.POST)
		public String save(Album album) {
			albumrepository.save(album);
			return "redirect:musiclist";
		}
		
		//Music db, editAlbum endpoint
		@RequestMapping(value = "/albumedit{id}", method = RequestMethod.GET)
		public String editAlbum(@PathVariable("id") Long albumId, Model model) {
			model.addAttribute("album", albumrepository.findById(albumId));
			return "editalbum";
		}
		
		//Music db, deleteAlbum endpoint (Only for admin)
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/albumdelete/{id}", method = RequestMethod.GET)
		public String deleteAlbum(@PathVariable("id") Long albumId, Model model) {
			albumrepository.deleteById(albumId);
			return"redirect:../musiclist";
		}
}