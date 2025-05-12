package org.example;

import org.example.client.ClientRepository;
import org.example.client.ClientResponse;
import org.mockito.Mockito;

public final class ClientService {

    private final ClientRepository client;

    public ClientService(ClientRepository client) {
        this.client = client;
        long definedId = client.definedId();
        Mockito.when(client.findById(definedId))
                .thenReturn(new ClientResponse(definedId, "Lou", "Tenat"));
        Mockito.when(client.findById(Mockito.longThat(id -> id != definedId)))
                .thenReturn(null);
    }

    public ClientResponse search(long id) {
        return client.findById(id);
    }
}