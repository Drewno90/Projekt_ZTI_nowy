package daw.projekt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import daw.projekt.service.ChatroomService;
import daw.projekt.entity.Blog;
import daw.projekt.entity.Item;
import daw.projekt.entity.Role;
import daw.projekt.entity.User;
import daw.projekt.example.chat.annotation.TransactionalRW;
import daw.projekt.example.chat.entity.Chatroom;
import daw.projekt.repository.BlogRepository;
import daw.projekt.repository.ItemRepository;
import daw.projekt.repository.RoleRepository;
import daw.projekt.repository.UserRepository;
@EnableJpaRepositories(basePackages="daw.projekt.repository", entityManagerFactoryRef="emf")
@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	
	@Autowired
	private ChatroomService chatroomService;

	@TransactionalRW
	@PostConstruct
	@Scheduled(fixedDelay = 86400000, initialDelay = 86400000)
	public void init(){
		
		if(roleRepository.findByName("ROLE_ADMIN")== null){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogJavavids = new Blog();
		blogJavavids.setName("JavaVids");
		blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJavavids.setUser(userAdmin);
		blogRepository.save(blogJavavids);
	/*	
		Item item1 = new Item();
		item1.setBlog(blogJavavids);
		item1.setTitle("first");
		item1.setLink("http://javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogJavavids);
		item2.setTitle("second");
		item2.setLink("http://javavids.com");
		item2.setPublishedDate(new Date());
	    itemRepository.save(item2);
		*/
		
		chatroomService.deleteAll();
		{
			Chatroom chatroom = new Chatroom();
			chatroom.setName("Soccer");
			chatroom.setDescription("The most popular game on Earth!");
			chatroomService.save(chatroom);
		}

		{
			Chatroom chatroom = new Chatroom();
			chatroom.setName("Programmers");
			chatroom.setDescription("How to code like a pro :)");
			chatroomService.save(chatroom);
		}

		{
			Chatroom chatroom = new Chatroom();
			chatroom.setName("Justin Bieber");
			chatroom.setDescription("Is it a boy or a woman?");
			chatroomService.save(chatroom);
		}
		System.out.println("*** FINISH INIT DATABASE ***");
		}
	}

}
