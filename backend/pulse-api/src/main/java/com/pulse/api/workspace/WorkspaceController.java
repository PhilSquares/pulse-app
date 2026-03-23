package com.pulse.api.workspace;

import org.springframework.web.bind.annotation.*;
import com.pulse.api.workspace.dto.WorkspaceResponse;
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
    public WorkspaceResponse createWorkspace(@RequestBody @Valid CreateWorkspaceRequest request) {

    Workspace workspace = workspaceService.createWorkspace(request.getName());

    return new WorkspaceResponse(
        workspace.getId(),
        workspace.getName()
        
    );
    } 

    @GetMapping
    public List<WorkspaceResponse> getWorkspaces() {

    return workspaceService.getAllWorkspaces()
        .stream()
        .map(w -> new WorkspaceResponse(w.getId(), w.getName()))
        .toList();
    }

    @GetMapping("/{id}")
    public WorkspaceResponse getWorkspaceById(@PathVariable Long id) {

    Workspace workspace = workspaceService.getWorkspaceById(id);

    return new WorkspaceResponse(
        workspace.getId(),
        workspace.getName()
    );
    }

    @DeleteMapping("/{id}")
    public void deleteWorkspace(@PathVariable Long id) {
        workspaceService.deleteWorkspace(id);
    }
}