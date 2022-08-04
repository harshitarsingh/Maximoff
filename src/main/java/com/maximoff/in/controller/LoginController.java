package com.maximoff.in.controller;

import com.maximoff.in.global.GlobalData;
import com.maximoff.in.model.Role;
import com.maximoff.in.model.User;
import com.maximoff.in.repository.RoleRepository;
import com.maximoff.in.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/login")
    public String login()
    {
        GlobalData.cart.clear();
        return "login";
    }

    @GetMapping("/register")
    public String getRegister()
    {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        String password= user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));

        List<Role> roles=new ArrayList<>();
        roles.add(roleRepository.findById(2).get());

        user.setRoles(roles);
        userRepository.save(user);

        request.login(user.getEmail(), password);
        return "redirect:/";

    }
}
