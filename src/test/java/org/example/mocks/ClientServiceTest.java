package org.example.mocks;

import static org.example.mocks.TestUtils.assertThat;

import org.example.ClientService;
import org.example.client.ClientRepository;
import org.example.client.ClientResponse;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockSettings;
import org.mockito.Mockito;

import java.util.Random;

import static org.example.mocks.TestUtils.assertThat;

public class ClientServiceTest {
    private static final Random RND = new Random();
    private static final long DEFINED_ID = RND.nextLong();

    private static final MockSettings MOCKITO_CONFIG = Mockito.withSettings()
            .verboseLogging();

    private ClientRepository client;

    @BeforeEach
    void setUp() {
        // arrange
        client = Mockito.mock(ClientRepository.class, MOCKITO_CONFIG);
        Mockito.when(client.definedId()).thenReturn(DEFINED_ID);
    }

    @Test
    void shouldBeConstructed() {
        // action-assert
        Assertions.assertDoesNotThrow(() -> new ClientService(client));
    }

    @Test
    void shouldReturnProperlyConfiguredResponse() {
        // arrange
        ClientService service = new ClientService(client);

        // action
        ClientResponse response = service.search(DEFINED_ID);

        // assert
        assertThat(response)
                .isNotNull()
                .hasId(DEFINED_ID)
                .hasName("Lou")
                .hasSurname("Tenat");
    }

    @Test
    void shouldReturnNullForNonConfiguredResponse() {
        // arrange
        ClientService service = new ClientService(client);
        long id;
        do {
            id = RND.nextLong();
        } while (id == DEFINED_ID);

        // action
        ClientResponse response = service.search(id);

        // assert
        assertThat(response).isNull();
    }
}
