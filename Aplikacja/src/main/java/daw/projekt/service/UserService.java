package daw.projekt.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daw.projekt.entity.Blog;
import daw.projekt.entity.Item;
import daw.projekt.entity.Role;
import daw.projekt.entity.User;
import daw.projekt.repository.BlogRepository;
import daw.projekt.repository.ItemRepository;
import daw.projekt.repository.RoleRepository;
import daw.projekt.repository.UserRepository;

@Service
@Transactional
public class UserService {

		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private RoleRepository roleRepository;
		
		@Autowired
		private BlogRepository blogRepository;
		
		@Autowired
		private ItemRepository itemRepository;
		
		public List<User> findAll() {
			return userRepository.findAll();
		}

		public User findOne(int id) {
			// TODO Auto-generated method stub
			return userRepository.findOne(id);
		}
		@Transactional
		public User findOneWithBlogs(int id) {
			User user = findOne(id);
			List<Blog> blogs = blogRepository.findByUser(user);
			for (Blog blog:blogs){
				List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0,10,Direction.DESC, "publishedDate"));
				blog.setItems(items);
			}
			user.setBlogs(blogs);
			return user;
		}

		public void save(User user) {
			user.setEnabled(true);
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByName("ROLE_USER"));
			user.setRoles(roles);
			
			userRepository.save(user);

		}
}