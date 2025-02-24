package com.example.springbootloginclase2425.auth;

import com.example.springbootloginclase2425.model.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Login Y Registro", description = "Endpoints del registro y el login")
public class AuthController {

    @Autowired
    private final AuthService authService;

    private Logger logger = Logger.getLogger(AuthController.class.getName());

    @PostMapping(value = "login")
    @Operation(summary = "Inciar Sesión", description = "Con este endpoint incias sesión cogiendo como parametro 'RequestBody'.")
    public ResponseEntity login(@RequestBody LoginRequest request) {
        try{
            logger.info("Intento de Incio de Sesión");
            return ResponseEntity.ok(authService.login(request));
        }catch (Throwable e){
            logger.severe(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Result.Error(e.getMessage()));
        }
    }

    @PostMapping(value = "register")
    @Operation(summary = "Registrarse", description = "Este endpoint te registra cogiendo como parametro 'RequestBody'.")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        logger.info("Intento de Registro de Usuario");
        return ResponseEntity.ok(authService.register(request));
    }
}
