package FinalProjectPeaku.Bambucod.exceptions.exceptionhandler;


import FinalProjectPeaku.Bambucod.exceptions.MessageException;
import FinalProjectPeaku.Bambucod.model.DTO.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionAdvisor {


    private final MessageSource messageSource;

    @ExceptionHandler(MessageException.class)
    public ResponseEntity<AuthResponse> handlerException(MessageException messageException){
        return ResponseEntity.status(messageException.getHttpStatus())
                .body(
                        AuthResponse.builder()
                                .message(messageSource.getMessage(messageException.getMessage(),null, Locale.getDefault()))
                                .build()

                );
    }
}
