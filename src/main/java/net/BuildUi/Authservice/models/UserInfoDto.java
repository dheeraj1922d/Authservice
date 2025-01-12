package net.BuildUi.Authservice.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import net.BuildUi.Authservice.entities.UserInfo;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto extends UserInfo {
    private String firstName;
    private String lastName;
    private Long phoneNo;
    private String email;
}
