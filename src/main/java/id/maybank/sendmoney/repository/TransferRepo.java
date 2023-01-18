package id.maybank.sendmoney.repository;

import id.maybank.sendmoney.entity.TransferAmount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepo extends JpaRepository<TransferAmount, Long> {
}
