package com.hashedin.apigatewayserver.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Id",dataType = "Long")
    private Long id;
    @ApiModelProperty(value = "Name",dataType = "String")
    private String name;
    @ApiModelProperty(value = "Username",dataType = "username")
    private String username;
    @ApiModelProperty(value = "password",dataType = "String")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role>roles=new ArrayList<>();
}