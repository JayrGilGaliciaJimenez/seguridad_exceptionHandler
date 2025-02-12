package utez.edu.mx.permanencia.practica_api.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import utez.edu.mx.permanencia.practica_api.config.ApiResponse;
import utez.edu.mx.permanencia.practica_api.models.BeanEmpresa;
import utez.edu.mx.permanencia.practica_api.models.EmpresaRepository;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public ResponseEntity<ApiResponse> saveEmpresa(BeanEmpresa empresa) {
        BeanEmpresa savedEmpresa = empresaRepository.save(empresa);
        ApiResponse<BeanEmpresa> response = new ApiResponse<>(
                HttpStatus.OK,
                "Empresa saved successfully",
                savedEmpresa
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
