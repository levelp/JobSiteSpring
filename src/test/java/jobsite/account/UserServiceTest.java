package jobsite.account;

import jobsite.model.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService = new UserService();
    @Mock
    private AccountRepository accountRepositoryMock;

    @Test
    public void shouldInitializeWithTwoDemoUsers() {
        // act
        userService.initialize();
        // assert
        verify(accountRepositoryMock, times(2)).save(any(Account.class));
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        // arrange
        when(accountRepositoryMock.findByEmail("user@example.com")).thenReturn(null);
        // act & assert
        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("user@example.com"));
    }

    @Test
    public void shouldReturnUserDetails() {
        // arrange
        Account demoUser = new Account("user@example.com", "demo", "ROLE_USER");
        when(accountRepositoryMock.findByEmail("user@example.com")).thenReturn(demoUser);

        // act
        UserDetails userDetails = userService.loadUserByUsername("user@example.com");

        // assert
        assertThat(demoUser.getEmail()).isEqualTo(userDetails.getUsername());
        assertThat(demoUser.getPassword()).isEqualTo(userDetails.getPassword());
        assertThat(hasAuthority(userDetails, demoUser.getRole()));
    }

    private boolean hasAuthority(UserDetails userDetails, String role) {
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals(role)) {
                return true;
            }
        }
        return false;
    }
}