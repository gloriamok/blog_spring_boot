package com.blog_spring_boot.blog_spring_boot.post;

import com.blog_spring_boot.blog_spring_boot.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    private Post mapToModel(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToModel(postDto);
        Post newPost = postRepository.save(post);
        return mapToDto(newPost);
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> postPage = postRepository.findAll(pageable);
        List<Post> postList = postPage.getContent();
        List<PostDto> postDtoList = postList.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtoList);
        postResponse.setPageNo(postPage.getNumber());
        postResponse.setPageSize(postPage.getSize());
        postResponse.setTotalElements(postPage.getTotalElements());
        postResponse.setTotalPages(postPage.getTotalPages());
        postResponse.setLast(postPage.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(Integer id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public String deletePostById(Integer id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        postRepository.delete(post);
        return "Post entity deleted successfully.";
    }


}
