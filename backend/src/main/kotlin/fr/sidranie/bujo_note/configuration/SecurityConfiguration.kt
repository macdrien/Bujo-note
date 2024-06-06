package fr.sidranie.bujo_note.configuration

import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain


@Configuration
class SecurityConfiguration {
    @Bean
    fun ignoringCustomizer(): WebSecurityCustomizer =
        WebSecurityCustomizer{ web -> web.ignoring().requestMatchers(PathRequest.toH2Console()) }

    @Bean
    @Throws(Exception::class)
    open fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http.authorizeHttpRequests { authorizeHttpRequests -> authorizeHttpRequests.requestMatchers("/**").permitAll() }
            .cors { customize -> customize.disable() }
            .build()
}
