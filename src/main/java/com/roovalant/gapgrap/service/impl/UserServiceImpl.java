//package com.roovalant.gapgrap.service.impl;
//
//import com.roovalant.gapgrap.domain.enumeration.ResourceType;
//import com.roovalant.gapgrap.repository.UserRepository;
//import com.roovalant.gapgrap.service.UserService;
//import com.roovalant.gapgrap.service.dto.UserDTO;
//import com.roovalant.gapgrap.service.mapper.UserMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Slf4j
//@RequiredArgsConstructor
//@Service
//@Transactional
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//
//    private final UserMapper userMapper;
//
//    @Override
//    public Page<UserDTO> findAll(Pageable pageable) {
//        log.debug("Request to get all Apts");
//        return userRepository.findAll(pageable).map(userMapper::toDto);
//    }
//
//    @Override
//    public Page<UserDTO> findAllByType(Pageable pageable, ResourceType type) {
//        return null;
//    }
//
//}
