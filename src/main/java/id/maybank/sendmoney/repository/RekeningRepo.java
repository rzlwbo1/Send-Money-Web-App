package id.maybank.sendmoney.repository;

import id.maybank.sendmoney.entity.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RekeningRepo extends JpaRepository<Rekening, Long> {
}
