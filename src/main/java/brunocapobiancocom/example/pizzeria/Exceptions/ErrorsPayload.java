package brunocapobiancocom.example.pizzeria.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorsPayload
{
    private String message;
    private LocalDateTime timeStamp;
}
