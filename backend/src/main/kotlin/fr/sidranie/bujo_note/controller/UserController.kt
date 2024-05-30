package fr.sidranie.bujo_note.controller

import fr.sidranie.bujo_note.dto.PatchUserDto
import fr.sidranie.bujo_note.dto.UserDto
import fr.sidranie.bujo_note.entity.User
import fr.sidranie.bujo_note.service.UserService
import fr.sidranie.bujo_note.transformer.UserTransformer
import jakarta.websocket.server.PathParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(
    val userService: UserService,
    val userTransformer: UserTransformer
) {

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getById(@PathParam("id") id: UUID): UserDto {
        val user: User = userService.getById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        return userTransformer.userToUserDto(user);
    }

    @CrossOrigin
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createUser(@RequestBody userDto: UserDto): UserDto {
        var user: User = userTransformer.userDtoToUser(userDto)

        user = userService.createUser(user);

        val created: UserDto = userTransformer.userToUserDto(user);
        return created
    }

    @PatchMapping("/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun patchUser(@PathParam("id") id: UUID, @RequestBody updates: PatchUserDto): UserDto {
        if (id != updates.id) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Not the same id");
        }

        var user: User = userService.getById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        user = userService.updateUser(user, updates);

        return userTransformer.userToUserDto(user);
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathParam("id") id: UUID): Unit = userService.deleteById(id)
}
