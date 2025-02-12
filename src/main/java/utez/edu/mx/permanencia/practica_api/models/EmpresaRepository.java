package utez.edu.mx.permanencia.practica_api.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<BeanEmpresa, Integer> {

}
