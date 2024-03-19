package FinalProjectPeaku.Bambucod.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NullException extends RuntimeException{

    private final HttpStatus httpStatus;

    public NullException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }


}
