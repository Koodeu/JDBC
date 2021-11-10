package categories;


import lombok.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CategoryDTO {

    @Getter
    private int id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String code;

    public CategoryDTO(String name, String code) {
        this.name = name;
        this.code = code;
    }


}
