package utez.edu.mx.permanencia.practica_api.config.exceptions;

import lombok.Getter;

@Getter
public class CustomBadRequestException extends RuntimeException {
    public CustomBadRequestException(String message) {
        super(message);
    }
}
