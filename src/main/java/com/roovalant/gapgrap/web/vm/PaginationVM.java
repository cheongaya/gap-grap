package com.roovalant.gapgrap.web.vm;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpHeaders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationVM<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * page: 페이지 번호
     */
    @Schema(name = "페이지 번호", example = "1")
    private Integer page = 1;

    /**
     * size: 페이지 사이즈
     */
    @Schema(name = "페이지 사이즈", example = "20")
    private Integer size = 20;

    /**
     * sort: 정렬 순서
     */
    @Schema(name = "sort: 정렬 순서")
    private String[] sort;

    /**
     * total: 총 갯수
     */
    @Schema(name = "총 갯수", example = "150")
    private Long total = 0L;

    /**
     * data: 데이터 목록
     */
    @Schema(name = "데이터 목록")
    private List<T> data = new ArrayList<>();

    public PaginationVM(HttpHeaders headers, List<T> data) {
        this.page = Integer.parseInt(headers.getFirst("x-page-no"));
        this.page++;
        this.size = Integer.parseInt(headers.getFirst("x-page-size"));
        this.total = Long.parseLong(headers.getFirst("x-total-count"));
        this.data = data;
    }

    public PaginationVM(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public PaginationVM(Integer page, Integer size, String[] sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}