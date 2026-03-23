package com.pulse.api;

import com.pulse.api.common.ApiResponse;
import com.pulse.api.workspace.WorkspaceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WorkspaceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> handleWorkspaceNotFound(WorkspaceNotFoundException ex) {
        return new ApiResponse<>(null, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleValidationErrors(MethodArgumentNotValidException ex) {

        FieldError fieldError = ex.getBindingResult().getFieldError();

        String message = fieldError != null
            ? fieldError.getDefaultMessage()
            : "Validation error";

        return new ApiResponse<>(null, message);
    }
}