package id.maybank.sendmoney.repository;

import id.maybank.sendmoney.entity.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RekeningRepo extends JpaRepository<Rekening, Long> {

    Rekening findByNoRek(String noRek);
}
