package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data //toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {

    public ProductDTO(String name, Float price, Long categoryId)
    {
        this.name = name;
        this.price = price;
        this.categoryId =categoryId;
    }
    @NotBlank(message="Tittle is required")
    @Size(min=2, max=255, message="Tittle is required be between 2 and 255 characters")
    private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    @Min(value=0, message="Price must be greater than or equal to 0")
    @Max(value=10000000, message="Price must be greater than or equal to 10000000")
    private Float price;
    public Float getPrice()
    {
        return price;
    }
    public void setPrice(Float price)
    {
        this.price = price;
    }
    private String thumbnail;
    public String getThumbnail()
    {
        return thumbnail;
    }
    public void setThumbnail()
    {
        this.thumbnail= thumbnail;
    }
    @JsonProperty("category_id")  // Điều này giúp thể hiện giống với SQL (Cơ sỡ dữ liệu) hơn
    private Long categoryId;
    public Long getCategoryId()
    {
        return categoryId;
    }
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    private List <MultipartFile> files;

    public List <MultipartFile> getFile() {
        return files;
    }
}
