package com.hashedin.apigatewayserver.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Role To User")
public class RoleToUserForm {
    @ApiModelProperty(value = "Username",dataType = "String")
    private String username;
    @ApiModelProperty(value = "Rolename",dataType = "String")
    private String roleName;
}
