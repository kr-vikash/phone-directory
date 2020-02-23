package com.directory.main.service.ServieImp;


import com.directory.main.modal.CustomUserDetail;
import com.directory.main.modal.User;
import com.directory.main.repo.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailCustomService implements UserDetailsService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            User user= profileRepository.findByUsername(s);
            if (user==null){
                throw new UsernameNotFoundException("User not found exception");
            }
            return new CustomUserDetail(user);
    }
}
