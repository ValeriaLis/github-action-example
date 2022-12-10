package com.example.lab4.Controllers;


import com.example.lab4.Models.Users;
import com.example.lab4.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class MainController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/users")
    public List<Users> users() {
        return usersRepository.findAll();
    }

    @GetMapping("/valuta")
    public String valuta() throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null;) {
                result.append(line);
            }
        }
        return result.toString();
    }
}
