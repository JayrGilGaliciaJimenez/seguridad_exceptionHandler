package utez.edu.mx.permanencia.practica_api.controllers;

import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.permanencia.practica_api.config.ApiResponse;
import utez.edu.mx.permanencia.practica_api.controllers.dto.EmpresaDTO;
import utez.edu.mx.permanencia.practica_api.models.BeanEmpresa;
import utez.edu.mx.permanencia.practica_api.services.EmpresaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/empresa")
@Builder
public class EmpresaConrtroller {

    private final EmpresaService empresaService;

    public EmpresaConrtroller(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping("/registrar")
        public ResponseEntity<ApiResponse> registrarEmpresa(@RequestBody EmpresaDTO empresaDTO) {
            BeanEmpresa empresa = new BeanEmpresa();
            empresa.setRazonSocial(empresaDTO.getRazonSocial());
            empresa.setRfc(empresaDTO.getRfc());
            empresa.setContacto(empresaDTO.getContacto());
            empresa.setTelefono(empresaDTO.getTelefono());
            empresa.setEmail(empresaDTO.getEmail());
            return empresaService.saveEmpresa(empresa);
        }

}
