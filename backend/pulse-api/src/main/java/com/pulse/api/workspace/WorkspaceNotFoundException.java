package com.pulse.api.workspace;

public class WorkspaceNotFoundException extends RuntimeException {

    public WorkspaceNotFoundException(Long id) {
        super("Workspace not found with id: " + id);
    }
}