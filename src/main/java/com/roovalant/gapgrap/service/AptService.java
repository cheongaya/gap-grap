package com.roovalant.gapgrap.service;

import com.roovalant.gapgrap.domain.enumeration.ResourceType;
import com.roovalant.gapgrap.service.dto.AptDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AptService {

    /**
     * Get all the apts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<AptDTO> findAll(Pageable pageable);

    /**
     * Get all the apts.
     *
     * @param pageable the pagination information.
     * @param type the type of resource..
     * @return the list of entities.
     */
    Page<AptDTO> findAllByType(Pageable pageable, ResourceType type);

}
