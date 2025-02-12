package utez.edu.mx.permanencia.practica_api.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class EmpresaDTO {
    private String razonSocial;
    private String rfc;
    private String contacto;
    private String telefono;
    private String email;
}
