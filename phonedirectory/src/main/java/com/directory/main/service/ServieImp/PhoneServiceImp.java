package com.directory.main.service.ServieImp;

import com.directory.main.modal.Contact;
import com.directory.main.modal.CustomUserDetail;
import com.directory.main.modal.User;
import com.directory.main.modal.UserDto;
import com.directory.main.repo.PhoneRepository;
import com.directory.main.repo.ProfileRepository;
import com.directory.main.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class PhoneServiceImp implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public long checkDublicates(List<Contact> contacts, Contact contact) {
        for (Contact c:contacts){
           if(c.getPhoneNumber().equals(contact.getPhoneNumber())){
               return c.getId();
           }
        }
        return -1;
    }

    @Override
    public long saveProfile(User user){
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        String encodedPassword=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        profileRepository.save(user);
        return user.getId();
    }

    @Override
    public UserDto getUser(Long id) {
        User userDetail=profileRepository.findOne(id);
        UserDto userDto=new UserDto();
        userDto.setUsername(userDetail.getUsername());
        userDto.setEmail(userDetail.getEmail());
        userDto.setId(userDetail.getId());
        return null;
    }

    @Override
    public UserDto getUserInfo(Principal principal){
        CustomUserDetail userDetail= (CustomUserDetail) ((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        UserDto userDto=new UserDto();
        userDto.setUsername(userDetail.getUsername());
        userDto.setEmail(userDetail.getEmail());
        userDto.setId(userDetail.getUserId());
        return userDto;
    }

}
