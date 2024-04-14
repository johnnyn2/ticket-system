package com.ticket.system.repository;

import com.ticket.system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    @Query(nativeQuery = true)
    List<Account> findTop1ByAccountNo(String accountNo);
}
