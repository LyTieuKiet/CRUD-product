package com.project.shopapp.models;

import com.project.shopapp.dtos.CategoryDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "product")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Product {

    public Product(String name, Float price, String thumbnail, Category category)
    {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.category = category;
    }
    @Id // Để mô tả đây là khóa chính của bảng Category khi ánh xạ với class model
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Giúp id là giá trị duy nhất và sẽ tăng lên nếu có thêm !!
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false) // Giúp phần name sẽ không bị bỏ trống
    private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    private Float price;
    public Float getPrice()
    {
        return price;
    }
    public void setPrice(Float price)
    {
        this.price = price;
    }
    @Column(name = "thumbnail", length = 350) // Giúp phần thumbnail có thể chứa tối đa 350 ký tự và có thể trống
    private String thumbnail;
    public String getThumbnail()
    {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail)
    {
        this.thumbnail= thumbnail;
    }

    private LocalDateTime createdAt;
    // Phần LocalDateTime giúp xác định được thời gian mà bảng ghi Product được tạo ra
    // Ta sử dụng hàm getter và setter để trả về thời gian mà chúng được tạo ra
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    private LocalDateTime updatedAt;

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
    @ManyToOne // Thể hiện mối quan hệ 1-nhiều giữa 2 quan hệ category và product
    @JoinColumn (name = "category_id") // Ánh xạ khóa ngoại (FOREIGN KEY) của category
    private Category category;
    public Category getCategory ()
    {
        return category;
    }
    public void setCategory(Category category)
    {
        this.category = category;
    }


}
