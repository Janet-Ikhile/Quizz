package com.adaze.quizz.controller;

import com.adaze.quizz.pojo.AuthenticationRequest;
import com.adaze.quizz.pojo.AuthenticationResponse;
import com.adaze.quizz.pojo.Question;
import com.adaze.quizz.security.JwtUtil;
import com.adaze.quizz.service.MyUserDetailsService;
import com.adaze.quizz.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuizzController {
    @Autowired
    QuizzService quizzService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @RequestMapping("/")
    public String tellThem(){
        return "Hello World";
    }

    @RequestMapping("/random-question")
    public Question getRandomQuestion(){
        return quizzService.randomQuestion();
    }


    @RequestMapping("/questions/category/{category}")
    public List<Question> getCategorizedQuestions(@PathVariable String category){
        return quizzService.getCategorizedQuestions(category);
    }

    @RequestMapping("/questions/{id}")
    public Optional<Question> getSelectedQuestion(@PathVariable Integer id) {
        return quizzService.getSelectedQuestion(id);
    }

    @PostMapping("/questions/add-question")
    public String addQuestions(@RequestBody Question question){
      quizzService.addQuestions(question);
        return "Successfully added questions";
    }
    @RequestMapping("/questions")
    public List<Question> getAllQuestions(){
        return quizzService.returnAllQuestions();
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
