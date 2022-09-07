package com.roovalant.gapgrap.service.mapper;

import com.roovalant.gapgrap.domain.Apt;
import com.roovalant.gapgrap.domain.User;
import com.roovalant.gapgrap.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", uses = {
}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper extends EntityMapper<UserDTO, Apt> {

    UserDTO toDto(User entity);

    User toEntity(UserDTO dto);

    default User fromId(Long id) {
        if (id == null) {
            return null;
        }
        Apt o = new Apt();
        o.setId(id);
        return o;
    }
}
