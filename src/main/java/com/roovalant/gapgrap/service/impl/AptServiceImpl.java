package com.roovalant.gapgrap.service.impl;

import com.roovalant.gapgrap.service.AptService;
import com.roovalant.gapgrap.service.dto.AptDTO;
import com.roovalant.gapgrap.service.util.PaginationUtil;
import com.roovalant.gapgrap.service.util.UriUtil;
import com.roovalant.gapgrap.web.vm.PaginationVM;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class AptServiceImpl implements AptService {

    private final ApplicationProperties applicationProperties;
    private final DataTemplate dataTemplate;

    @Override
    public ResponseEntity<List<AptDTO>> getAllApts(PaginationVM pagination, Map<String,String> filters, String authorization) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(UriUtil.HTTP)
                .host(applicationProperties.getService().getPlusData())
                .path("/api/apts")
                .queryParams(PaginationUtil.generatePaginationParamsWithFilters(pagination, filters))
                .queryParam("sort", "timeAgo,desc")
                .build()
                .encode();

        return dataTemplate
                .get(uriComponents.toUri(), new ParameterizedTypeReference<List<AptDTO>>() {}, authorization);
    }
}
