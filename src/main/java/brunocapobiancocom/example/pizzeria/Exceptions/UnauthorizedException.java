package brunocapobiancocom.example.pizzeria.Exceptions;

public class UnauthorizedException extends RuntimeException
{
    public UnauthorizedException(String message)
    {
        super(message);
    }
}
