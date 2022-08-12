package com.roovalant.gapgrap.service;

import com.roovalant.gapgrap.service.dto.AptDTO;
import com.roovalant.gapgrap.web.vm.PaginationVM;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AptService {

    /**
     * Get all the Apts.
     *
     * @param pagination the pagination information
     * @param filters the filters to retrieve
     * @return the list of entities
     */
    ResponseEntity<List<AptDTO>> getAllApts(PaginationVM pagination, Map<String,String> filters, String authorization);
}
