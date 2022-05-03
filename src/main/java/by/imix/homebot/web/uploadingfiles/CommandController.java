package by.imix.homebot.web.uploadingfiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;

@Controller
public class CommandController {

    @GetMapping("/command/")
    public String listUploadedFiles(Model model) throws IOException {


        return "commandForm";
    }
}
