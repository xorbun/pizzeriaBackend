package brunocapobiancocom.example.pizzeria.Exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException
{
    public NotFoundException(UUID id)
    {
        super("l' elemento con id "+ id +" non è stato trovato");
    }
    public NotFoundException(String message)
    {
        super("l elemento "+ message +" non è stato trovato");
    }
}
