package org.techwipes.apartmentmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techwipes.apartmentmanager.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
