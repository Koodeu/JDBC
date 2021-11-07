package publisher;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublisherDTO {

    private int id;
    private String name;
    private String dialingCode;
    private String phoneNumber;
    private String email;
    private String description;

}
