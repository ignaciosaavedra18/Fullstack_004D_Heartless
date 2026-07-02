package com.duoc.heartless.config;

import com.duoc.heartless.model.Usuario;
import com.duoc.heartless.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

@Bean
CommandLineRunner initAdmin(
        UsuarioRepository usuarioRepository,
        PasswordEncoder passwordEncoder
) {

    return args -> {

        if (usuarioRepository.findByUsername("admin").isEmpty()) {

            Usuario admin = new Usuario();

            admin.setUsername("ADMIN");
            admin.setPassword(
                    passwordEncoder.encode("hola123")
            );

            admin.setRole("ROLE_ADMIN");

            usuarioRepository.save(admin);

            System.out.println("ADMIN creado correctamente");
        }
    };
}

}
