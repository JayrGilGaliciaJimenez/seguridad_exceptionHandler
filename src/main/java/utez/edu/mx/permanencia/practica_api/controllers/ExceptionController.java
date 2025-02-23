package utez.edu.mx.permanencia.practica_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.permanencia.practica_api.config.exceptions.CustomBadRequestException;
import utez.edu.mx.permanencia.practica_api.config.exceptions.ResourceNotFoundException;
import utez.edu.mx.permanencia.practica_api.config.exceptions.UnauthorizedException;

@RestController("api/")
public class ExceptionController {

    @GetMapping("/exception/{exceptionType}")
    public void throwException(@PathVariable String exceptionType) {
        switch (exceptionType) {
            case "unauthorized":
                throw new UnauthorizedException("No tienes permiso para acceder a este recurso -> CODIGO DE ERROR: E-401");
            case "notFound":
                throw new ResourceNotFoundException("Recurso no encontrado -> CODIGO DE ERROR: E-404");
            case "badRequest":
                throw new CustomBadRequestException("Petición incorrecta -> CODIGO DE ERROR: E-400");
            default:
                throw new RuntimeException("Error desconocido -> CODIGO DE ERROR: E-500");

        }
    }

}
