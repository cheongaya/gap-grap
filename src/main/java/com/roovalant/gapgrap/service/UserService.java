package com.roovalant.gapgrap.service;

import com.roovalant.gapgrap.domain.enumeration.ResourceType;
import org.springframework.data.domain.Pageable;

public interface UserService {

    /**
     * Get all the users.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<UserDTO> findAll(Pageable pageable);

    /**
     * Get all the apts.
     *
     * @param pageable the pagination information.
     * @param type the type of resource..
     * @return the list of entities.
     */
    Page<UserDTO> findAllByType(Pageable pageable, ResourceType type);

}
