package com.driver.services.impl;

import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.model.User;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository3;
    @Autowired
    ServiceProviderRepository serviceProviderRepository3;
    @Autowired
    CountryRepository countryRepository3;

    @Override
    public User register(String username, String password, String countryName) throws Exception{
        //create a user of given country. The originalIp of the user should be "countryCode.userId" and return the user.
        //Note that right now user is not connected and thus connected would be false and maskedIp would be null
        //Note that the userId is created automatically by the repository layer
        User user = new User();
        String countryCode = "";
        user.setUsername(username);
        user.setPassword(password);
        countryName = countryName.toUpperCase();
        Country country = new Country();
        if(countryName.equals("IND")){
            country.setCountryName(CountryName.IND);
        }
        else if(countryName.equals("AUS")){
            country.setCountryName(CountryName.AUS);
        }
        else if(countryName.equals("CHI")){
            country.setCountryName(CountryName.CHI);
        }
        else if(countryName.equals("JPN")){
            country.setCountryName(CountryName.JPN);
        }
        else if(countryName.equals("USA")){
            country.setCountryName(CountryName.USA);
        }
        countryCode = country.getCountryName().toCode();
        country.setCode(countryCode);
        country.setUser(user);
        user.setOriginalCountry(country);
        user = userRepository3.save(user);
        int userId = user.getId();
        user.setOriginalIp(countryCode+"."+userId);
        user.setMaskedIp(null);
        user.setConnected(false);
        user = userRepository3.save(user);
        return user;
    }

    @Override
    public User subscribe(Integer userId, Integer serviceProviderId) {
        //subscribe to the serviceProvider by adding it to the list of providers and return updated User
        User user = userRepository3.findById(userId).get();
        ServiceProvider serviceProvider = serviceProviderRepository3.findById(serviceProviderId).get();
        serviceProvider.getUsers().add(user);
        user.getServiceProviderList().add(serviceProvider);
        user = userRepository3.save(user);
        return user;
    }
}
