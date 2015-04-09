package daw.projekt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daw.projekt.entity.Blog;
import daw.projekt.entity.Item;
import daw.projekt.entity.User;
import daw.projekt.repository.BlogRepository;
import daw.projekt.repository.ItemRepository;
import daw.projekt.repository.UserRepository;

@Service
public class UserService {

		@Autowired
		private UserRepository userRepository;
		
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
}
