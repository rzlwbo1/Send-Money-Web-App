package id.maybank.sendmoney.repository;

import id.maybank.sendmoney.entity.HistoryTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<HistoryTransfer, Long> {
}
