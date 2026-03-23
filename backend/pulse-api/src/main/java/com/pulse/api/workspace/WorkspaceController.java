package com.pulse.api.workspace;

import org.springframework.web.bind.annotation.*;
import com.pulse.api.common.ApiResponse;
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
    public ApiResponse<WorkspaceResponse> createWorkspace(
        @RequestBody @Valid CreateWorkspaceRequest request) {

    Workspace workspace = workspaceService.createWorkspace(request.getName());

    WorkspaceResponse response = new WorkspaceResponse(
        workspace.getId(),
        workspace.getName()
    );

    return new ApiResponse<>(response, "Workspace created successfully");
    }

    @GetMapping
    public ApiResponse<List<WorkspaceResponse>> getWorkspaces() {

    List<WorkspaceResponse> response = workspaceService.getAllWorkspaces()
        .stream()
        .map(w -> new WorkspaceResponse(w.getId(), w.getName()))
        .toList();

    return new ApiResponse<>(response, "Workspaces retrieved successfully");
    }

    @GetMapping("/{id}")
    public ApiResponse<WorkspaceResponse> getWorkspaceById(@PathVariable Long id) {

    Workspace workspace = workspaceService.getWorkspaceById(id);

    WorkspaceResponse response = new WorkspaceResponse(
        workspace.getId(),
        workspace.getName()
    );

    return new ApiResponse<>(response, "Workspace retrieved successfully");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteWorkspace(@PathVariable Long id) {

    workspaceService.deleteWorkspace(id);

    return new ApiResponse<>(null, "Workspace deleted successfully");
    }
}