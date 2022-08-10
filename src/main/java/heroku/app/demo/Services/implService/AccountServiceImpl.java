package heroku.app.demo.Services.implService;

import heroku.app.demo.DTOs.AccountDTO;
import heroku.app.demo.Entities.Account;
import heroku.app.demo.Entities.Role;
import heroku.app.demo.Exceptions.AppException;
import heroku.app.demo.Exceptions.ErrorMessage;
import heroku.app.demo.HResponse.HResponse;
import heroku.app.demo.Repositories.AccountRepository;
import heroku.app.demo.Repositories.RoleRepository;
import heroku.app.demo.Services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ModelMapper mapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public HResponse signupAccountClient(AccountDTO dto) {

        Account account = mapper.map(dto, Account.class);
        account.setPassword(passwordEncoder.encode(dto.getPassword()));
        account.setIsActive(1);
        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByRoleName("ROLE_USER");
        if(role == null) {
            return HResponse.buildHResponse(ErrorMessage.ROLE_NOT_FOUND);
        }
        roles.add(role);
        account.setRoles(roles);
//        Set<String> strRoles = dto.getRoles();
//        if( strRoles == null ){
//            return HResponse.buildHResponse(ErrorMessage.ROLE_EMPTY);
//        }
//        Set<Role> roles = new HashSet<>();
//        for( String r : strRoles ){
//            switch (r){
//                case "ROLE_ADMIN":
//                    Role adminRole = roleRepository.findRolesByRoleName("ROLE_ADMIN")
//                            .orElseThrow(() -> new NoSuchElementException());
//                    roles.add(adminRole);
//                    break;
//                case "ROLE_USER":
//                    Role userRole = roleRepository.findRolesByRoleName("ROLE_USER")
//                            .orElseThrow(() -> new NoSuchElementException());
//                    roles.add(userRole);
//                    break;
//                default:
//                    return HResponse.buildHResponse(ErrorMessage.ROLE_NOT_FOUND);
//            }
//        }
        account = accountRepository.save(account);

        return HResponse.buildHResponse(dto);
    }
}
