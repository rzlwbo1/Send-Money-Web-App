package id.maybank.sendmoney.service.provider;

import id.maybank.sendmoney.entity.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> getAllBank();
    void savebank(Provider provider);

}
