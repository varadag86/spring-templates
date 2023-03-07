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
import org.springframework.web.bind.annotation.*;

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

    @Operation(
            summary = "User Controller",
            description = "Get user by id."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = User.class
                                            )
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Failed with bad request",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = User.class
                                            )
                                    )
                            )
                    ),
            }
    )
    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable long id) throws Exception {
        User user = this.userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Add user controller",
            description = "Add new user."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Upon successful addition of new user.",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = User.class
                                            )
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Failed with bad request",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = User.class
                                            )
                                    )
                            )
                    ),
            }
    )
    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@RequestBody User user) throws Exception {
        User userInfo = this.userService.addNewUser(user);
        return new ResponseEntity<>(userInfo, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Update existing user by userId",
            description = "Update existing user by userId."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Upon successful addition of new user.",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = User.class
                                            )
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Failed with bad request",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = User.class
                                            )
                                    )
                            )
                    ),
            }
    )
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateExistingUser(@PathVariable long id,  @RequestBody User user) throws Exception {
        User userInfo = this.userService.updateExistingUser(id, user);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @Operation(
            summary = "Update existing user by userId",
            description = "Update existing user by userId."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Upon successful addition of new user.",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = User.class
                                            )
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Failed with bad request",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = User.class
                                            )
                                    )
                            )
                    ),
            }
    )
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Long> deleteExistingUser(@PathVariable long id) throws Exception {
        this.userService.deleteUser(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }
}
