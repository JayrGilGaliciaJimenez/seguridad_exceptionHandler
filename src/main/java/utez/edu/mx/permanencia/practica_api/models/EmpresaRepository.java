package utez.edu.mx.permanencia.practica_api.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<BeanEmpresa, Integer> {
    @Query(value = "SELECT * FROM empresa WHERE uuid=:uuid", nativeQuery = true)
    Optional<BeanEmpresa> findByUuid(String uuid);

}
