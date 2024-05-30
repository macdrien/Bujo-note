package fr.sidranie.bujo_note.service.impl

import fr.sidranie.bujo_note.dao.UserDao
import fr.sidranie.bujo_note.dto.PatchUserDto
import fr.sidranie.bujo_note.entity.User
import fr.sidranie.bujo_note.service.UserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    val userDao: UserDao
) : UserService {
    override fun getById(id: UUID): User? {
        return userDao.findByIdOrNull(id);
    }

    override fun createUser(user: User): User {
        user.id = UUID.randomUUID();
        return userDao.save(user);
    }

    override fun updateUser(user: User, updates: PatchUserDto): User {
        val updatedUser = user.copy(
            username = updates.username ?: user.username,
            givenName = updates.givenName ?: user.givenName,
            familyName = updates.familyName ?: user.familyName,
            email = updates.email ?: user.email,
        );
        return userDao.save(updatedUser);
    }

    override fun deleteById(id: UUID) {
        userDao.deleteById(id);
    }
}
