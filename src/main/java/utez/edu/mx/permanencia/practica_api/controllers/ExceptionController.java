package utez.edu.mx.permanencia.practica_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.permanencia.practica_api.config.exceptions.CustomBadRequestException;
import utez.edu.mx.permanencia.practica_api.config.exceptions.ResourceNotFoundException;
import utez.edu.mx.permanencia.practica_api.config.exceptions.UnauthorizedException;

@RestController("api/")
public class ExceptionController {
    @GetMapping("/unauthorized")
    public void throwUnauthorized() {
        throw new UnauthorizedException("No tienes permiso para acceder a este recurso.");
    }

    @GetMapping("/exception/{exceptionType}")
    public void throwException(@PathVariable String exceptionType) {
        switch (exceptionType) {
            case "unauthorized":
                throw new UnauthorizedException("No tienes permiso para acceder a este recurso.");
            case "notFound":
                throw new ResourceNotFoundException("Recurso no encontrado");
            case "badRequest":
                throw new CustomBadRequestException("Petición incorrecta");
            default:
                throw new RuntimeException("Error desconocido");

        }
    }

}
