package mz.vm.portal.service;

import mz.vm.portal.domain.DocumentType;

import java.util.List;

public interface IDocumentTypeService extends ModifiableAndQuerable<DocumentType, Long> {

    /**
     * List all Document Type with same name
     *
     * @param name
     * @return
     */
    List<DocumentType> findAllByName(String name);
    List<DocumentType> findAllDocs();
}
