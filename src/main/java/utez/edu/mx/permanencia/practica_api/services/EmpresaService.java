package utez.edu.mx.permanencia.practica_api.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import utez.edu.mx.permanencia.practica_api.config.ApiResponse;
import utez.edu.mx.permanencia.practica_api.config.exceptions.ResourceNotFoundException;
import utez.edu.mx.permanencia.practica_api.models.BeanEmpresa;
import utez.edu.mx.permanencia.practica_api.models.EmpresaRepository;

import java.util.Optional;

@Service
public class EmpresaService {
    private static final Logger log = LogManager.getLogger(EmpresaService.class);
    private final EmpresaRepository empresaRepository;
    @Value("${spring.profiles.active}")
    private String activeProfile;



    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public ResponseEntity<ApiResponse> saveEmpresa(BeanEmpresa empresa) {
        BeanEmpresa savedEmpresa = empresaRepository.save(empresa);
        ApiResponse<BeanEmpresa> response = new ApiResponse<>(
                HttpStatus.OK,
                "UUID: " + savedEmpresa.getUuid(),
                null,
                savedEmpresa
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse<BeanEmpresa>> findById(int id) {
        Optional<BeanEmpresa> empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isPresent()) {
            ApiResponse<BeanEmpresa> response = new ApiResponse<>(
                    HttpStatus.OK,
                    "Empresa encontrada",
                    null,
                    empresaOptional.get()
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Empresa no encontrada -> CODIGO DE ERROR: E-404");
        }
    }

    public ResponseEntity<ApiResponse<BeanEmpresa>> findByUUID(String uuid){
        Optional<BeanEmpresa> empresaOptional = empresaRepository.findByUuid(uuid);
        if (empresaOptional.isPresent()) {
            ApiResponse<BeanEmpresa> response = new ApiResponse<>(
                    HttpStatus.OK,
                    "Empresa encontrada",
                    null,
                    empresaOptional.get()
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Empresa no encontrada -> CODIGO DE ERROR: E-404");
        }

    }

    public ResponseEntity<ApiResponse> getActiveProfile(){
        ApiResponse<String> response = new ApiResponse<>(
                HttpStatus.OK,
                "Perfil activo encontrado",
                null,
                activeProfile
        );
        //log.info(activeProfile);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
