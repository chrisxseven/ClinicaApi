package com.clinica.api.controller;

import com.clinica.api.datasource.model.Usuario;
import com.clinica.api.repository.UsuarioRepository;
import com.clinica.api.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(body.get("email"), body.get("senha"))
            );
            String token = jwtService.gerarToken(body.get("email"));

            Usuario usuario = usuarioRepository.findByEmail(body.get("email"))
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "nome", usuario.getNome()
            ));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(Map.of("erro", "Email ou senha inválidos."));
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody Map<String, String> body) {

        if (!body.containsKey("nome") || body.get("nome").trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("erro", "O nome é obrigatório."));
        }

        if (usuarioRepository.findByEmail(body.get("email")).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("erro", "Email já cadastrado."));
        }

        Usuario u = new Usuario();

        u.setNome(body.get("nome"));

        u.setEmail(body.get("email"));
        u.setSenha(passwordEncoder.encode(body.get("senha")));
        u.setRole("USER");
        usuarioRepository.save(u);

        return ResponseEntity.ok(Map.of("mensagem", "Usuário criado com sucesso."));
    }
}