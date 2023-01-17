package id.maybank.sendmoney.repository;

import id.maybank.sendmoney.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepo extends JpaRepository<Provider, Long> {
}
