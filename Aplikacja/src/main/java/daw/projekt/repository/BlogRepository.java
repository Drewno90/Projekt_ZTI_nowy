package daw.projekt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import daw.projekt.entity.Blog;
import daw.projekt.entity.User;


public interface BlogRepository extends JpaRepository<Blog, Integer>{

		List<Blog> findByUser(User user);
}
