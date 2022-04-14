package hhpalvelinohjelmointi.Musicdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import hhpalvelinohjelmointi.Musicdb.domain.AlbumRepository;
import hhpalvelinohjelmointi.Musicdb.domain.SongRepository;

@CrossOrigin
@Controller
public class CombinedController {
	@Autowired
	private SongRepository songrepository;
	
	@Autowired
	private AlbumRepository albumrepository;
	
	//All of the endpoints
		//Songs and albums
		@RequestMapping(value="/musiclist")
		public String musiclist(Model model) {
			model.addAttribute("songs", songrepository.findAll());
			model.addAttribute("albums", albumrepository.findAll());
			return "listmusic";
		}
}
