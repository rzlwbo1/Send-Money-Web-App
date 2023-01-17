package id.maybank.sendmoney.service.provider;

import id.maybank.sendmoney.entity.Provider;
import id.maybank.sendmoney.repository.ProviderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService{

    @Autowired
    private ProviderRepo providerRepo;

    @Override
    public List<Provider> getAllBank() {
        return this.providerRepo.findAll();
    }

    @Override
    public void savebank(Provider provider) {
        this.providerRepo.save(provider);
    }
}
