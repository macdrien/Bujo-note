package fr.sidranie.bujo_note.dao

import fr.sidranie.bujo_note.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserDao: CrudRepository<User, UUID>
