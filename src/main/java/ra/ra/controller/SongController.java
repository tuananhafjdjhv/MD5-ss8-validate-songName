package ra.ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.ra.model.Song;
import ra.ra.service.ISongService;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class SongController {

    @Autowired
     ISongService songService;

    @GetMapping({"/", "/home"})
    public ModelAndView getAll(@PageableDefault(sort = "name", size = 3) Pageable pageable) {
        Page<Song> list = songService.findAll(pageable);
       ModelAndView mv = new ModelAndView("index");
       mv.addObject("list",list);

        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateProduct() {
        ModelAndView mv = new ModelAndView("add");
        mv.addObject("createSong", new Song());
        return mv;
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("createSong") Song song, BindingResult br) {
        if (br.hasFieldErrors()) {
            return "add";
        }
        songService.save(song);
        return "redirect:/home";
    }
}
