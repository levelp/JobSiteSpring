
package jobsite.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// NOTE: This class is a placeholder and is not registered as a Spring bean.
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement user loading logic from your repository
        // This is just a placeholder that should be replaced with actual implementation
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
