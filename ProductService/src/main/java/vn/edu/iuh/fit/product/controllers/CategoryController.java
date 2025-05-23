package vn.edu.iuh.fit.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.product.exceptions.CategoryException;
import vn.edu.iuh.fit.product.models.dtos.PageDTO;
import vn.edu.iuh.fit.product.models.dtos.requests.CategoryRequest;
import vn.edu.iuh.fit.product.models.dtos.responses.BaseResponse;
import vn.edu.iuh.fit.product.models.dtos.responses.CategoryProminentResponse;
import vn.edu.iuh.fit.product.models.dtos.responses.CategoryResponse;
import vn.edu.iuh.fit.product.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Thêm - chỉnh sửa danh mục thuốc
    @PostMapping
    public ResponseEntity<BaseResponse<CategoryResponse>> addCategory(@RequestBody CategoryRequest request) throws CategoryException {
        CategoryResponse category = categoryService.save(request);
        return ResponseEntity.ok(
                BaseResponse
                        .<CategoryResponse>builder()
                        .data(category)
                        .success(true)
                        .build()
        );
    }

    //Cập nhật danh mục thuốc
    @PutMapping
    public ResponseEntity<BaseResponse<CategoryResponse>> updateCategory(@RequestBody CategoryRequest request) throws CategoryException {
        CategoryResponse category = categoryService.save(request);
        return ResponseEntity.ok(
                BaseResponse
                        .<CategoryResponse>builder()
                        .data(category)
                        .success(true)
                        .build()
        );
    }

    //Tìm danh mục thuốc theo category_id
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<CategoryResponse>> getCategoryById(@PathVariable Long id) throws CategoryException {
        CategoryResponse category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(
                BaseResponse
                        .<CategoryResponse>builder()
                        .data(category)
                        .success(true)
                        .build()
        );
    }

    //Danh sách các danh mục thuốc cha cấp 1
    @GetMapping("/get-category-level1")
    public ResponseEntity<BaseResponse<List<CategoryResponse>>> getParentCategories() {
        List<CategoryResponse> categories = categoryService.getAllParentCategories();
        return ResponseEntity.ok(
                BaseResponse
                        .<List<CategoryResponse>>builder()
                        .data(categories)
                        .success(true)
                        .build()
        );
    }

    //Danh sách các danh mục con theo parent_id
    @GetMapping("/get-by-parent-id/{parentId}")
    public ResponseEntity<BaseResponse<List<CategoryResponse>>> getChildCategories(@PathVariable Long parentId) {
        List<CategoryResponse> categories = categoryService.getAllChildCategories(parentId);
        return ResponseEntity.ok(
                BaseResponse
                        .<List<CategoryResponse>>builder()
                        .data(categories)
                        .success(true)
                        .build()
        );
    }

    //Tìm Danh mục theo tên (title)
    @GetMapping("/get-by-title")
    public ResponseEntity<BaseResponse<List<CategoryResponse>>> getCategoryByTitle(@RequestParam String title) {
        List<CategoryResponse> categories = categoryService.getCategoryByTitle(title);
        return ResponseEntity.ok(
                BaseResponse
                        .<List<CategoryResponse>>builder()
                        .data(categories)
                        .success(true)
                        .build()
        );
    }

    // Tìm danh mục theo level
    @GetMapping("/get-by-level")
    public ResponseEntity<BaseResponse<List<CategoryResponse>>> getCategoryByLevel(@RequestParam int level) {
        List<CategoryResponse> categories = categoryService.getCategoryByLevel(level);
        return ResponseEntity.ok(
                BaseResponse
                        .<List<CategoryResponse>>builder()
                        .data(categories)
                        .success(true)
                        .build()
        );
    }
    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse<List<CategoryResponse>>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(
                BaseResponse
                        .<List<CategoryResponse>>builder()
                        .data(categories)
                        .success(true)
                        .build()
        );
    }


    @GetMapping("/get-prominent")
    public ResponseEntity<BaseResponse<List<CategoryProminentResponse>>> getProminent() {
        List<CategoryProminentResponse> categories = categoryService.getProminent();
        return ResponseEntity.ok(
                BaseResponse
                        .<List<CategoryProminentResponse>>builder()
                        .data(categories)
                        .success(true)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<BaseResponse<PageDTO<CategoryResponse>>> getPagesCategory(@RequestParam(defaultValue = "0") int page ,
                                                                                    @RequestParam(defaultValue = "10") int size,
                                                                                    @RequestParam (required = false) String sortBy,
                                                                                    @RequestParam (required = false) String sortName) {
        PageDTO<CategoryResponse> pageDTO = categoryService.getPagesCategory(page, size, sortBy, sortName);
        return ResponseEntity.ok(
                BaseResponse
                        .<PageDTO<CategoryResponse>>builder()
                        .data(pageDTO)
                        .success(true)
                        .build()
        );
    }
}
