package com.pulse.api.workspace;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public Workspace createWorkspace(String name) {

        Workspace workspace = new Workspace();
        workspace.setName(name);

        return workspaceRepository.save(workspace);
    }

    public List<Workspace> getAllWorkspaces() {
        return workspaceRepository.findAll();
    }
}