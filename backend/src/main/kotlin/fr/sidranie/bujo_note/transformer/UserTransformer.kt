package fr.sidranie.bujo_note.transformer

import fr.sidranie.bujo_note.dto.UserDto
import fr.sidranie.bujo_note.entity.User
import org.springframework.stereotype.Component

@Component
class UserTransformer {
    fun userToUserDto(user: User): UserDto {
        return UserDto(
            user.id,
            user.username,
            user.givenName,
            user.familyName,
            user.password,
            user.email
        )
    }

    fun userDtoToUser(userDto: UserDto): User {
        if (userDto.id == null) {
            throw NullPointerException("UserDto id can't be null to call UserTransformer.userDtoToUser")
        }
        return User(
            userDto.id,
            userDto.username,
            userDto.givenName,
            userDto.familyName,
            userDto.password,
            userDto.email
        )
    }
}
