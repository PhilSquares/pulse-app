package com.pulse.api;

import com.pulse.api.workspace.WorkspaceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WorkspaceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleWorkspaceNotFound(WorkspaceNotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }
}