package mz.vm.portal.service.impl;

import mz.vm.portal.domain.DocumentType;
import mz.vm.portal.repository.DocumentTypeRepository;
import mz.vm.portal.service.AbstractModifiableAndQuerable;
import mz.vm.portal.service.IDocumentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeService extends AbstractModifiableAndQuerable<DocumentType, Long> implements IDocumentTypeService {
    private final DocumentTypeRepository repository;

    public DocumentTypeService(DocumentTypeRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<DocumentType> findAllByName(String name) {
        return repository.findAllByNameLike(name);
    }

    @Override
    public List<DocumentType> findAllDocs() {
        return repository.findAll();
    }
}
