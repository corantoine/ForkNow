package fr.simplon.spring_security.serviceTest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.Optional;

import fr.simplon.spring_security.model.User;
import fr.simplon.spring_security.model.UserRole;
import fr.simplon.spring_security.repository.UserRepository;
import fr.simplon.spring_security.service.impl.UserServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceImplTest {

    //test ok
    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    public UserServiceImplTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByUsername(){
        User mockUser = new User(1L, "lala", "lulu", "lolo@mail.com","azerty", UserRole.CUSTOMER);
        when(userRepository.findByUsername("lala")).thenReturn(Optional.of(mockUser));

        //orElseThrow permet d'extraire la valeur du optional
        User result = userServiceImpl.findByUsername("lala").orElseThrow();

        assertEquals("lala", result.getUsername());
        verify(userRepository).findByUsername("lala");
    }


}
