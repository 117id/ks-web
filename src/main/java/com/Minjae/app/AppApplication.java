package com.Minjae.app;

import com.Minjae.app.Entity.*;
import com.Minjae.app.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
// public class AppApplication implements CommandLineRunner
	private final PersonRepository personRepository;
	private final SocialMediaRepository socialMediaRepository;
	private final SkillRepository skillRepository;
	private final InterestsRepository interestsRepository;
	private final WorkRepository workRepository;

	public AppApplication(PersonRepository personRepository, SocialMediaRepository socialMediaRepository, SkillRepository skillRepository, InterestsRepository interestsRepository, WorkRepository workRepository){
		this.personRepository = personRepository;
		this.socialMediaRepository = socialMediaRepository;
		this.skillRepository = skillRepository;
		this.interestsRepository = interestsRepository;
		this.workRepository = workRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
//		run, 즉 오류처리,그외 경우 처리를 해주지 않으면 오류가 발생한다.
		personRepository.save(new Person("김민재", "백엔드", "hello@test.com", "010-1234-5678"));
		socialMediaRepository.save(new SocialMedia("117id/ws-web", "No", "No", "No"));
		skillRepository.save(new Skill("No",  100));
		interestsRepository.save(new Interests("VALORANT"));
		workRepository.save(new Work("Noob","Not Yet","05:52","0"));
	}
}
