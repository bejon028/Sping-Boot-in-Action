package readinglist;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Bijon on 3/30/2017.
 */
@Slf4j
@RequestMapping("/")
@Controller
public class ReadingListController {
    @Autowired
    private ReadingListRepository readingListRepository;
//    @Autowired
//    private ReaderRepository readerRepository;

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {

        log.debug("something,{}",reader);
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        String hello = "sdfsdf";
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }

//    @RequestMapping(value = "/{username}/{password}", method = RequestMethod.GET)
//    public String addUser(@PathVariable("username") String username, @PathVariable("password") String password) {
//        Reader reader = new Reader();
//        reader.setPassword(password);
//        reader.setUsername(username);
//        readerRepository.saveAndFlush(reader);
//        System.out.println("saving data");
//        return "redirect:/login";
//    }
//
//    @RequestMapping(value = "login-success", method = RequestMethod.GET)
//    public String redirectUser() {
//        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
//        return "redirect:/".concat(userName);
//    }

}
