package mz.vm.portal.controller;

import mz.vm.portal.DocumentTypeDTO;
import mz.vm.portal.domain.DocumentType;
import mz.vm.portal.service.impl.DocumentTypeService;
import mz.vm.portal.util.InfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "document")
public class DocumentTypeController extends AbstractModifiableAndQuerableController<DocumentType, Long, DocumentTypeDTO> {

    private final DocumentTypeService service;

    @Autowired
    public DocumentTypeController(DocumentTypeService service) {
        super(service, DocumentType.class, DocumentTypeDTO.class);
        this.service = service;
    }

    @GetMapping("find-by-name/{name}")
    public ResponseEntity<List<DocumentTypeDTO>> findDocumentTypeByName(@PathVariable String name) {
        return ResponseEntity.ok().body(service.findAllByName(name).stream().map(document -> InfoUtils.toInfo(document, DocumentTypeDTO.class)).collect(Collectors.toList()));
    }

    @RequestMapping("/findAllDocs")
    public ResponseEntity<List<DocumentTypeDTO>> findAllDocs() {
        return ResponseEntity.ok().body(service.findAllDocs().stream().map(document -> InfoUtils.toInfo(document, DocumentTypeDTO.class)).collect(Collectors.toList()));
    }
}
