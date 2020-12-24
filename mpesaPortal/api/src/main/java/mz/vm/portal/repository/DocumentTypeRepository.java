package mz.vm.portal.repository;

import mz.vm.portal.domain.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {

    List<DocumentType> findAllByNameLike(String name);
}
