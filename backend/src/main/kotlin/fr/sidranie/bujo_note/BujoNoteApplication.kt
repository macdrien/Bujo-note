package fr.sidranie.bujo_note

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["fr.sidranie.bujo_note.dao"])
class BujoNoteApplication

fun main(args: Array<String>) {
	runApplication<BujoNoteApplication>(*args)
}
