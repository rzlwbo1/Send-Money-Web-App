package id.maybank.sendmoney;

import id.maybank.sendmoney.entity.Nasabah;
import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.repository.NasabahRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SendmoneyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SendmoneyApplication.class, args);
	}

	@Autowired
	private NasabahRepo nasabahRepo;
	@Override
	public void run(String... args) throws Exception {
		LocalDate date = LocalDate.now();

		Rekening rekening1 = new Rekening();
		rekening1.setNoRek("09876112");

		Rekening rekening2 = new Rekening();
		rekening2.setNoRek("09876113");

		List<Rekening> rekenings = new ArrayList<>();
		rekenings.add(rekening1);
		rekenings.add(rekening2);

//		Set<Rekening> rekeningSet = new HashSet<>();
//		rekeningSet.add(rekening1);
//		rekeningSet.add(rekening2);

		Nasabah nasabah = new Nasabah();
		nasabah.setFullName("Rizal wibowo");
		nasabah.setEmail("zal@mail.com");
		nasabah.setDob(date);
		nasabah.setNoContact("1229310");
		nasabah.setNoIdentitas("18291329129");
		nasabah.setTipeIdentias("KTP");
		nasabah.setRekenings(rekenings);

//		rekening1.setNasabah(nasabah);
//		rekening2.setNasabah(nasabah);

		this.nasabahRepo.save(nasabah);
//		System.out.println(rekening1.getNasabah().getFullName()) ;

	}
}
