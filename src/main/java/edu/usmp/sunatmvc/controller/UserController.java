package edu.usmp.sunatmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import edu.usmp.sunatmvc.model.User;
import edu.usmp.sunatmvc.model.Fact;
import edu.usmp.sunatmvc.repository.UserRepository;

import java.util.Optional;

import javax.validation.Valid;
import edu.usmp.sunatmvc.service.GDHService;
import org.springframework.validation.BindingResult;
@Controller
public class UserController {

    private final UserRepository userData;
    private static final String MESSAGE_ATTRIBUTE = "message"; 
    private static final String USER_INDEX ="login";
    private static final String HOME_INDEX ="home/index"; 

    public UserController(UserRepository userData) {
        this.userData = userData;
    }

    @GetMapping("/")
    public String login(Model model) {
        User usuario = new User();
        model.addAttribute("user", usuario);
        return USER_INDEX;
    }

    @PostMapping("login")
    public String login(Model model,
        @Valid User objUser, BindingResult result 
        ){
        String page;
        if(result.hasFieldErrors()) {
            model.addAttribute(MESSAGE_ATTRIBUTE, "Ingrese la informacion mandatoria");
            page = USER_INDEX;
        }else{
           Optional<User> userDB = this.userData.findById(objUser.getRuc());
           if(userDB.isPresent()){
                if(objUser.getPassword().equals(userDB.get().getPassword())){
                    model.addAttribute("factura", new Fact());
                    page = HOME_INDEX;
                }else{
                    model.addAttribute(MESSAGE_ATTRIBUTE, "Password no coincide");
                    page = USER_INDEX;
                }
           }else{
                model.addAttribute(MESSAGE_ATTRIBUTE, "Usuario no existe");
                page = USER_INDEX;
           }
        }
        return page;
    }

}

