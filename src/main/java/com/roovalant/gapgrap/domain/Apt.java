//package com.roovalant.gapgrap.domain;
//
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.apache.commons.lang3.builder.ToStringStyle;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.io.Serializable;
//
///**
// * The Apt entity
// *
// * @author: DEVROOT
// * @since: 2022.08.20
// */
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
//@Table(name = "apt")
//public class Apt implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * id: 아파트 식별자
//     */
//    @Id
//    @NotNull
//    @Size(max = 40)
//    @Column(name = "id", length = 40, unique = true, nullable = false)
//    private String id;
//
//    /**
//     * name: 이름
//     */
//    @Size(max = 255)
//    @Column(name = "name", length = 255)
//    private String name;
//
//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
//    }
//
//
//    public void setId(Long id) {
//    }
//}
