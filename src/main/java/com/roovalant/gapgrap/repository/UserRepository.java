package com.roovalant.gapgrap.repository;

import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the Product entity.
 *
 * @author DEVROOT
 * @since 2022.08.27
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
}

