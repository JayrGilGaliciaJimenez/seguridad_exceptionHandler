package utez.edu.mx.permanencia.practica_api.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link utez.edu.mx.permanencia.practica_api.models.BeanEmpresa}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BeanEmpresaDto implements Serializable {
    private String razonSocial;
    private String rfc;
    private String contacto;
    private String telefono;
    private String email;
}