package utez.edu.mx.permanencia.practica_api.controllers;

import lombok.Builder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger log = LogManager.getLogger(EmpresaConrtroller.class);
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

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BeanEmpresa>> getEmpresa(@PathVariable Integer id) {
        return empresaService.findById(id);
    }

    @GetMapping("u/{uuid}")
    public ResponseEntity<ApiResponse<BeanEmpresa>> getEmpresaByUUID(@PathVariable String uuid){
        return empresaService.findByUUID(uuid);
    }

    @GetMapping("/profile")
    public ResponseEntity<ApiResponse> getActiveProfile(){
        return empresaService.getActiveProfile();
    }


}
