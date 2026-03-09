package com.pulse.api.workspace;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/workspaces")
public class WorkspaceController {

    private final WorkspaceRepository workspaceRepository;

    public WorkspaceController(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    @PostMapping
    public Workspace createWorkspace(@RequestBody CreateWorkspaceRequest request) {

        Workspace workspace = new Workspace();
        workspace.setName(request.getName());

        return workspaceRepository.save(workspace);
    }

    @GetMapping
    public List<Workspace> getWorkspaces() {
        return workspaceRepository.findAll();
    }
}