package id.maybank.sendmoney.repository;

import id.maybank.sendmoney.entity.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NasabahRepo extends JpaRepository<Nasabah, Long> {
}
