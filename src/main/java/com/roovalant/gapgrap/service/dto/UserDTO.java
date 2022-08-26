package com.roovalant.gapgrap.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AptDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id: 식별자
     */
    @Schema(description = "식별자", accessMode = Schema.AccessMode.AUTO)
    private Long id;

    /**
     * name: 이름
     */
    @Size(max = 255)
    @Schema(description = "이름")
    private String name;

    /**
     * address: 주소
     */
    @Size(max = 16_777_215)
    @Schema(description = "주소")
    private String address;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}