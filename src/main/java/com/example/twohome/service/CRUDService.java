package com.example.twohome.service;

import com.example.twohome.model.IDEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
@SuppressWarnings({ "Duplicates", "unchecked" })
@Transactional
public abstract class CRUDService<T extends IDEntity, ID extends Serializable> {
    private static final Logger logger = LoggerFactory.getLogger(CRUDService.class);
    protected JpaRepository<T, ID> repository;
    protected final Class<T> typeParameterClass;

    public CRUDService(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public T get(ID id) {
        return repository.findById(id).orElse(null);
    }

    public List<T> getFull() {
        return repository.findAll();
    }

    public Page<T> getFull(Pageable pageable) { return repository.findAll(pageable);}

    public T create(T entity) {
        beforeCreate(entity);
        repository.save(entity);
        afterCreate(entity);
        return entity;
    }

    protected void afterCreate(T entity) {
        // do something after create
    }

    protected void beforeCreate(T entity) {
        // do something after create
    }

    public T update(T entity, ID id) {
        beforeUpdate(entity);
        T old = get(id);
        if(entity.getCreated() == null) entity.setCreated(old.getCreated());
        if(entity.getCreatedBy() == null) entity.setCreatedBy(old.getCreatedBy());
        if(old == null) throw new EntityNotFoundException("No entity with id: " + id);
        repository.save(entity);
        afterUpdate(entity);
        return entity;
    }

    protected void afterUpdate(T entity) {
        // do something after update
    }

    protected void beforeUpdate(T entity) {
        // do something after update
    }

    public void delete(T entity) {
        beforeDelete(entity);
        repository.delete(entity);
        afterDelete(entity);
    }

    public void deleteById(ID id) {
        T entity = get(id);
        delete(entity);
    }

    protected void afterDelete(T entity) {
        // do something after delete
    }

    protected void beforeDelete(T entity) {
        // do something before delete
    }

    public String HandleErrorMessage(String key) {
        logger.info("Error 400: {}", key);
        return key;
    }

//    protected void writeLog(String className, String methodName, String payload, String status){
//        logger.info("Classname {} Method {} {} Entity {}", className, methodName, status, payload);
//    }

}
