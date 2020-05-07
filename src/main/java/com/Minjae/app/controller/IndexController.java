package com.Minjae.app.controller;

import com.Minjae.app.Entity.*;
import com.Minjae.app.Repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private final PersonRepository personRepository;
    private final SocialMediaRepository socialMediaRepository;
    private final SkillRepository skillRepository;
    private final InterestsRepository interestsRepository;
    private final WorkRepository workRepository;

    public IndexController(PersonRepository personRepository, SocialMediaRepository socialMediaRepository, SkillRepository skillRepository, InterestsRepository interestsRepository, WorkRepository workRepository){
        this.personRepository = personRepository;
        this.socialMediaRepository = socialMediaRepository;
        this.skillRepository = skillRepository;
        this.interestsRepository = interestsRepository;
        this.workRepository = workRepository;
    }

    @GetMapping("/")
    public String index(Model model){
//      Modell model 선언 하는 이유 체크
        Person person = personRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("person",person);

        SocialMedia socialMedia = socialMediaRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("socialMedia", socialMedia);

        List<Interests> interests = interestsRepository.findAll();
        model.addAttribute("interests", interests);

        List<Skill> skills = skillRepository.findAll();
        model.addAttribute("skills", skills);

        List<Work> works = workRepository.findAll();
        model.addAttribute("works", works);

        return "resume";
    }

}
