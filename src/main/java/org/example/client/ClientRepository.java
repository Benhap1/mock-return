package org.example.client;

public interface ClientRepository {

    long definedId();

    ClientResponse findById(long id);
}
