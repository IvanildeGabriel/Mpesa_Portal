package mz.vm.portal.controller;

import mz.vm.portal.AbstractDTO;
import mz.vm.portal.service.ModifiableAndQuerable;
import mz.vm.portal.util.InfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractModifiableAndQuerableController<E extends Persistable<I>, I, D extends AbstractDTO> {

    @Autowired
    protected ModifiableAndQuerable<E, I> service;
    protected final Class<E> entityType;
    protected final Class<D> infoType;

    public AbstractModifiableAndQuerableController(ModifiableAndQuerable<E, I> service, Class<E> entityType, Class<D> infoType) {
        this.service = service;
        this.entityType = entityType;
        this.infoType = infoType;
    }

    @PostMapping("create")
    public ResponseEntity<D> createCategory(@RequestBody @Valid D info) {
        return ResponseEntity.ok().body(InfoUtils.toInfo(service.create(InfoUtils.toInfo(info, entityType)), infoType));
    }

    @DeleteMapping("delete")
    public void deleteCategory(@RequestParam I id) {
        service.delete(id);
    }

    @PostMapping("update")
    public ResponseEntity<D> updateCategory(@RequestBody @Valid D info) {
        return ResponseEntity.ok().body(InfoUtils.toInfo(service.update(InfoUtils.toInfo(info, entityType)), infoType));
    }

    @GetMapping("all")
    public ResponseEntity<List<D>> getAllCategory() {
        return ResponseEntity.ok().body(service.findAll().stream().map(category -> InfoUtils.toInfo(category, infoType)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable I id) {
        return ResponseEntity.ok().body(InfoUtils.toInfo(service.findById(id), infoType));
    }
}
