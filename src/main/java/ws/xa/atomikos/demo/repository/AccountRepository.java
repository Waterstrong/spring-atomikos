package ws.xa.atomikos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ws.xa.atomikos.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
