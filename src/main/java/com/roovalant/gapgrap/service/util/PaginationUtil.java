package com.roovalant.gapgrap.service.util;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public final class PaginationUtil {

    private static final String PAGE_PARAM = "page";

    private static final String SIZE_PARAM = "size";

    private static final String SORT_PARAM = "sort";

    private static final String PAGE_NO_HEADER = "X-Page-No";

    private static final String PAGE_SIZE_HEADER = "X-Page-Size";

    private static final String TOTAL_COUNT_HEADER = "X-Total-Count";

    public static HttpHeaders generatePaginationHttpHeaders(HttpHeaders responseHeaders, String baseUrl) {

        final Integer page = 1 + Integer.parseInt(responseHeaders.getFirst(PAGE_NO_HEADER));
        final Integer size = Integer.parseInt(responseHeaders.getFirst(PAGE_SIZE_HEADER));
        final Integer total = Integer.parseInt(responseHeaders.getFirst(TOTAL_COUNT_HEADER));

        HttpHeaders headers = new HttpHeaders();
        headers.add(PAGE_NO_HEADER, String.valueOf(page));
        headers.add(PAGE_SIZE_HEADER, String.valueOf(size));
        headers.add(TOTAL_COUNT_HEADER, String.valueOf(total));

        int totalPages = total / size;
        if (total % (size * page) != 0) {
            totalPages += 1;
        }

        String link = "";
        if (page < totalPages) {
            link = "<" + generateUri(baseUrl, page + 1, size) + ">; rel=\"next\",";
        }
        // prev link
        if (page > 1) {
            link += "<" + generateUri(baseUrl, page - 1, size) + ">; rel=\"prev\",";
        }
        // last and first link
        int lastPage = totalPages;
        link += "<" + generateUri(baseUrl, lastPage, size) + ">; rel=\"last\",";
        link += "<" + generateUri(baseUrl, 1, size) + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    private static String generateUri(String baseUrl, int page, int size) {
        return UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("page", page)
                .queryParam("size", size)
                .toUriString();
    }
}
