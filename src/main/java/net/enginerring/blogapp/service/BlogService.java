package net.enginerring.blogapp.service;

import net.enginerring.blogapp.model.Blog;
import net.enginerring.blogapp.respository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public Blog createBlog(Blog blog) {
        blog.setCreatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable).getContent();
    }

    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
    }

    public Blog updateBlog(Long id, Blog blogDetails) {
        Blog blog = getBlogById(id);
        blog.setTitle(blogDetails.getTitle());
        blog.setContent(blogDetails.getContent());
        blog.setAuthor(blogDetails.getAuthor());
        return blogRepository.save(blog);
    }

    public void deleteBlog(Long id) {
        Blog blog = getBlogById(id);
        blogRepository.delete(blog);
    }
}
