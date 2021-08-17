package br.com.mesttra.medicaldep.repository;

import br.com.mesttra.medicaldep.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {
}