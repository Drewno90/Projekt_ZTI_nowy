package daw.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import daw.projekt.entity.Blog;
import daw.projekt.entity.User;
import daw.projekt.repository.BlogRepository;
import daw.projekt.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
	}

	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog")Blog blog) {
		blogRepository.delete(blog);
	}


	public Blog findOne(int id) {

		return blogRepository.findOne(id);
	}

}
