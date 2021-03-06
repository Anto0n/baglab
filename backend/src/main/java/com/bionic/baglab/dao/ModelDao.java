package com.bionic.baglab.dao;

import com.bionic.baglab.domains.ModelEntity;
import com.bionic.baglab.dto.enums.ModelStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
//@RepositoryRestResource(collectionResourceRel = "models", path = "models")
public interface ModelDao extends CrudRepository<ModelEntity, Long> {

//    @Query("select e from ModelEntity e where e.deleted = false")
//    List<ModelEntity> findExistent();

  /*  @Query("select model from ModelEntity model where model.user.idUser = :id")
    List<ModelEntity> findAllModelsbyUserId (@Param ("id") long userId);
*/
        public List<ModelEntity> findAllModelsByUserId (long userId);
        public List<ModelEntity> findAllModelsByApproved (ModelStatus approved);


//    @Query("update ModelEntity e set e.priceEntities")
//    void setPrice(@Param("modelId") Long modeId, @Param("price") Long newPrice);
}
