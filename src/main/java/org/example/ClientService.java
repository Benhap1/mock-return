package org.example;

import org.example.client.ClientRepository;
import org.example.client.ClientResponse;
import org.mockito.Mockito;

public final class ClientService {

    private final ClientRepository client;

    public ClientService(ClientRepository client) {
        this.client = client;
        // TODO write your code here

    }

    public ClientResponse search(long id) {
        return client.findById(id);
    }
}
