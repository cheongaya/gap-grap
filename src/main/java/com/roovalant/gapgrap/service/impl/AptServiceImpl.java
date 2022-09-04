package com.roovalant.gapgrap.service.impl;

import com.roovalant.gapgrap.domain.enumeration.ResourceType;
import com.roovalant.gapgrap.repository.AptRepository;
import com.roovalant.gapgrap.service.AptService;
import com.roovalant.gapgrap.service.dto.AptDTO;
import com.roovalant.gapgrap.service.mapper.AptMapper;
import com.roovalant.gapgrap.service.util.PaginationUtil;
import com.roovalant.gapgrap.service.util.UriUtil;
import com.roovalant.gapgrap.web.vm.PaginationVM;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class AptServiceImpl implements AptService {

    private final AptRepository aptRepository;

    private final AptMapper aptMapper;

//    private final ApplicationProperties applicationProperties;
//    private final DataTemplate dataTemplate;
//
//    @Override
//    public ResponseEntity<List<AptDTO>> getAllApts(PaginationVM pagination, Map<String,String> filters, String authorization) {
//
//        UriComponents uriComponents = UriComponentsBuilder.newInstance()
//                .scheme(UriUtil.HTTP)
//                .host(applicationProperties.getService().getPlusData())
//                .path("/api/apts")
//                .queryParams(PaginationUtil.generatePaginationParamsWithFilters(pagination, filters))
//                .queryParam("sort", "timeAgo,desc")
//                .build()
//                .encode();
//
//        return dataTemplate
//                .get(uriComponents.toUri(), new ParameterizedTypeReference<List<AptDTO>>() {}, authorization);
//    }

    @Override
    public Page<AptDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Apts");
        return aptRepository.findAll(pageable).map(aptMapper::toDto);
    }

    @Override
    public Page<AptDTO> findAllByType(Pageable pageable, ResourceType type) {
        return null;
    }
}
