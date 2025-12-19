package com.phope.hope.Repository;

import com.phope.hope.Entity.Account;
import com.phope.hope.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
