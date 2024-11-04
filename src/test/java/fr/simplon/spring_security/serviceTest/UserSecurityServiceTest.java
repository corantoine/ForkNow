package fr.simplon.spring_security.serviceTest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import fr.simplon.spring_security.model.User;
import fr.simplon.spring_security.model.UserRole;
import fr.simplon.spring_security.service.UserSecurityService;
import fr.simplon.spring_security.service.UserService;

public class UserSecurityServiceTest {

    @Mock
    //Crée une instance simulée
    private UserService userService;

    @InjectMocks
    // Injecte ce que tu as mocké dans la classe de test
    private UserSecurityService userSecurityService;

    public UserSecurityServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoadUserByUsernameShouldReturnUserDetails(){
        User mockUser = new User(1L, "lala", "lulu","lolo@mail.com", "azerty", UserRole.CUSTOMER);
        when(userService.findByUsername("lala")).thenReturn(Optional.of(mockUser));

        User result = (User) userSecurityService.loadUserByUsername("lala");

        assertEquals("lala", result.getUsername());
        verify(userService).findByUsername("lala");
    }

}
