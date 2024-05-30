package fr.sidranie.bujo_note.service

import fr.sidranie.bujo_note.dto.PatchUserDto
import fr.sidranie.bujo_note.entity.User
import java.util.*

interface UserService {
    fun getById(id: UUID): User?;
    fun createUser(user: User): User;
    fun updateUser(user: User, updates: PatchUserDto): User;
    fun deleteById(id: UUID);
}
