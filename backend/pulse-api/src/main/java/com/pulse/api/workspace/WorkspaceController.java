package com.pulse.api.workspace;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/workspaces")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @PostMapping
    public Workspace createWorkspace(@RequestBody @Valid CreateWorkspaceRequest request) {
        return workspaceService.createWorkspace(request.getName());
    }

    @GetMapping
    public List<Workspace> getWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/{id}")
    public Workspace getWorkspaceById(@PathVariable Long id) {
        return workspaceService.getWorkspaceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkspace(@PathVariable Long id) {
        workspaceService.deleteWorkspace(id);
    }
}