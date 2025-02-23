package utez.edu.mx.permanencia.practica_api.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@Table(name = "empresa", schema = "empresas_db")
@NoArgsConstructor
@AllArgsConstructor
public class BeanEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    private String uuid;

    @Column(name = "razon_social", length = 32)
    private String razonSocial;

    @Column(name = "rfc", length = 13)
    private String rfc;

    @Column(name = "contacto", length = 32)
    private String contacto;

    @Column(name = "telefono", length = 13)
    private String telefono;

    @Column(name = "email", length = 32)
    private String email;

    @PrePersist
    protected void onCreate(){
        this.uuid = String.valueOf(UUID.randomUUID());
    }

}