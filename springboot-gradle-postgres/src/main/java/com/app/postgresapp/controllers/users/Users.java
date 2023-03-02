package com.app.postgresapp.controllers.users;

import com.app.postgresapp.domain.User;
import com.app.postgresapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Users {

    @Autowired
    private UserService userService;
    @Operation(
            summary = "User Controller",
            description = "Get all users."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = User[].class
                                            )
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Failed with bad request",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = User[].class
                                            )
                                    )
                            )
                    ),
            }
    )
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> UserList = this.userService.getAllUsers();
        return new ResponseEntity<>(UserList, HttpStatus.OK);
    }
}
