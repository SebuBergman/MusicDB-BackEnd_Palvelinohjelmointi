package hhpalvelinohjelmointi.Musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hhpalvelinohjelmointi.Musicdb.domain.AlbumRepository;
import hhpalvelinohjelmointi.Musicdb.domain.SongRepository;

@CrossOrigin
@Controller
public class CombinedController {
	@Autowired
	private SongRepository songrepository;

	@Autowired
	private AlbumRepository albumrepository;

	// All of the endpoints
	// Songs and albums
	@RequestMapping(value = "/musiclist")
	public String musiclist(Model model) {
		model.addAttribute("songs", songrepository.findAll());
		model.addAttribute("albums", albumrepository.findAll());
		return "musiclist";
	}

	// Guest Endpoints
	// Guest show database items
	@RequestMapping(value = "/musiclistguest", method = RequestMethod.GET)
	public String showDatabaseGuest(Model model) {
		model.addAttribute("songs", songrepository.findAll());
		model.addAttribute("albums", albumrepository.findAll());
		return "musiclistguest";
	}

	// Login and main page
	// Login mapping for Songdb
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Login mapping for the song database
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showMainpage(Model model) {
		return "welcome";
	}
}
