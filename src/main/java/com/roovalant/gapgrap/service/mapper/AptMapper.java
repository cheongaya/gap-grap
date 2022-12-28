//package com.roovalant.gapgrap.service.mapper;
//
//import com.roovalant.gapgrap.domain.Apt;
//import com.roovalant.gapgrap.service.dto.AptDTO;
//import org.mapstruct.Mapper;
//import org.mapstruct.NullValueCheckStrategy;
//
//@Mapper(componentModel = "spring", uses = {
//}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
//public interface AptMapper extends EntityMapper<AptDTO, Apt> {
//
//    AptDTO toDto(Apt entity);
//
//    Apt toEntity(AptDTO dto);
//
//    default Apt fromId(Long id) {
//        if (id == null) {
//            return null;
//        }
//        Apt o = new Apt();
//        o.setId(id);
//        return o;
//    }
//}
