package net.BuildUi.Authservice.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import net.BuildUi.Authservice.entities.UserInfo;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDto extends UserInfo {
    private String firstName;
    private String lastName;
    private Long phoneNo;
    private String email;
}
