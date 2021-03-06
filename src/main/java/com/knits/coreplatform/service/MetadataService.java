package com.knits.coreplatform.service;

import com.knits.coreplatform.service.dto.MetadataDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.knits.coreplatform.domain.Metadata}.
 */
public interface MetadataService {
    /**
     * Save a metadata.
     *
     * @param metadataDTO the entity to save.
     * @return the persisted entity.
     */
    MetadataDTO save(MetadataDTO metadataDTO);

    /**
     * Partially updates a metadata.
     *
     * @param metadataDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<MetadataDTO> partialUpdate(MetadataDTO metadataDTO);

    /**
     * Get all the metadata.
     *
     * @return the list of entities.
     */
    List<MetadataDTO> findAll();

    /**
     * Get the "id" metadata.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MetadataDTO> findOne(Long id);

    /**
     * Delete the "id" metadata.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
