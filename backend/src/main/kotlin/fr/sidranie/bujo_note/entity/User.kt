package fr.sidranie.bujo_note.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import java.util.*

@Entity
@Table(name = "users")
data class User(
    @Id
    var id: UUID,

    @Column(nullable = false, unique = true)
    var username: String?,

    @Column(nullable = false)
    var password: String?,

    @Column(nullable = false, unique = true)
    var email: String?,

    var givenName: String?,

    var familyName: String?
)
