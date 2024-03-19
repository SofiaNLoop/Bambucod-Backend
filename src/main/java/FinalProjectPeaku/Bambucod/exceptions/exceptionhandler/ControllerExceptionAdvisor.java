package FinalProjectPeaku.Bambucod.exceptions.exceptionhandler;


import FinalProjectPeaku.Bambucod.exceptions.NullException;
import FinalProjectPeaku.Bambucod.model.DTO.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionAdvisor {


    private final MessageSource messageSource;

    @ExceptionHandler(NullException.class)
    public ResponseEntity<AuthResponse> handlerException(NullException nullException){
        return ResponseEntity.status(nullException.getHttpStatus())
                .body(
                        AuthResponse.builder()
                                .message(messageSource.getMessage(nullException.getMessage(),null, Locale.getDefault()))
                                .build()

                );
    }
}
