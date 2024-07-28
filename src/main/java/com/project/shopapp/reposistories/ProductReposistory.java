package com.project.shopapp.reposistories;

import com.project.shopapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductReposistory extends JpaRepository<Product,Long> {
    // Các phương thức được cung cấp sẵn FindAll hay FindProduct by ID (Long)
    // Có thể thêm các phương thức khác nếu cần thiết
    boolean existsByName (String name); // Hàm boolean giúp kiểm tra tên sản phẩm đã tồn tại hay chưa

}
