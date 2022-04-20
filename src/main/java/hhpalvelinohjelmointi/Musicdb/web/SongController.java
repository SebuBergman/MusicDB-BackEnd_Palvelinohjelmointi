package hhpalvelinohjelmointi.Musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hhpalvelinohjelmointi.Musicdb.domain.AlbumRepository;
import hhpalvelinohjelmointi.Musicdb.domain.Song;
import hhpalvelinohjelmointi.Musicdb.domain.SongRepository;

@CrossOrigin
@Controller
public class SongController {
	@Autowired
	private SongRepository songrepository;

	@Autowired
	AlbumRepository albumrepository;

	// All of the song endpoints
	// Songs, Show all songs endpoint
	@RequestMapping(value = "/listsongs")
	public String songlist(Model model) {
		model.addAttribute("songs", songrepository.findAll());
		model.addAttribute("albums", albumrepository.findAll());
		return "songlist";
	}

	// Music db, addSong endpoint
	@RequestMapping(value = "/addsong")
	public String addSong(Model model) {
		model.addAttribute("song", new Song());
		model.addAttribute("albums", albumrepository.findAll());
		return "addsong";
	}

	// Music db, saveSong endpoint
	@RequestMapping(value = "/savesong", method = RequestMethod.POST)
	public String save(Song song) {
		songrepository.save(song);
		return "redirect:musiclist";
	}

	// Music db, editSong endpoint
	@RequestMapping(value = "/songedit{id}", method = RequestMethod.GET)
	public String editSong(@PathVariable("id") Long songId, Model model) {
		model.addAttribute("song", songrepository.findById(songId));
		model.addAttribute("albums", albumrepository.findAll());
		return "editsong";
	}

	// Music db, deleteSong endpoint (Only for admin)
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/songdelete/{id}", method = RequestMethod.GET)
	public String deleteSong(@PathVariable("id") Long songId, Model model) {
		songrepository.deleteById(songId);
		return "redirect:../musiclist";
	}
}