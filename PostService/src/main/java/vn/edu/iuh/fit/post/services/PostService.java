package vn.edu.iuh.fit.post.services;

import vn.edu.iuh.fit.post.exceptions.PostException;
import vn.edu.iuh.fit.post.model.dto.response.CommentResponse;
import vn.edu.iuh.fit.post.model.dto.response.PostResponse;
import vn.edu.iuh.fit.post.model.dto.request.PostRequest;

import java.io.IOException;
import java.util.List;

public interface PostService {
    //tạo bài post
    PostResponse createPost(PostRequest postRequest) throws PostException;

    // cập nhật bài post
    PostResponse updatePost(Long postId, PostRequest postRequest) throws PostException;

    // xóa bài post
    void deletePost(Long postId) throws PostException;

    //  Tìm kiếm bài viết theo tiêu đề gần đúng
    List<PostResponse> searchPosts(String title) throws PostException;

    //lấy danh sách bài viet
    List<PostResponse> getPosts() throws PostException;

    // lấy danh sách bài viết của tôi
    List<PostResponse> getMyPosts(Long authorId) throws PostException;

    PostResponse findById(Long postId) throws PostException;
}
