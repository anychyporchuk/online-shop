package dto;

import lombok.*;

@Data
@EqualsAndHashCode(/*callSuper = true*/)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
}
